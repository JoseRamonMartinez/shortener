package com.shortener.infrastructure.api;

import com.shortener.application.RedirectResolver;
import com.shortener.application.UrlMappingFinder;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingFilter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class UrlMappingGetControllerTest {

	@InjectMocks
	private UrlMappingGetController urlMappingGetController;

	@Mock
	private UrlMappingFinder urlMappingFinder;

	@Test
	void shouldReturnUrlMapping() {
		UrlMapping urlMapping = new UrlMapping("https://www.google.com", "Y8hF8Fh", LocalDateTime.now(), LocalDateTime.now().plusDays(30));
		when(this.urlMappingFinder.find(any())).thenReturn(new PageImpl<>(List.of(urlMapping), Pageable.ofSize(1), 1));
		ResponseEntity<?> response = this.urlMappingGetController.index(new UrlMappingFilter(false, null, null), Pageable.unpaged());
		assert response.getStatusCode().is2xxSuccessful();

	}

}
