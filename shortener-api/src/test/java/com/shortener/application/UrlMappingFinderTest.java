package com.shortener.application;

import com.shortener.domain.IdGenerator;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingFilter;
import com.shortener.domain.UrlMappingRepository;
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
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class UrlMappingFinderTest {

	@InjectMocks
	private UrlMappingFinder urlMappingFinder;

	@Mock
	private UrlMappingRepository urlMappingRepository;


	@Test
	void shouldReturnUrlMapping() {
		UrlMapping urlMapping = new UrlMapping("https://www.google.com", "Y8hF8Fh", LocalDateTime.now(), LocalDateTime.now().plusDays(30));
		when(this.urlMappingRepository.find(any())).thenReturn(new PageImpl<>(List.of(urlMapping), Pageable.ofSize(1), 1));
		Page<UrlMapping> urlMappingPage = urlMappingFinder.find(new UrlMappingFilter(false, null,null));
		assert urlMappingPage.getContent().size() == 1;
		verify(this.urlMappingRepository, times(1)).find(any());
	}
}
