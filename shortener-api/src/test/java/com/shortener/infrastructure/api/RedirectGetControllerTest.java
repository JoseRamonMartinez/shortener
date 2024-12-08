package com.shortener.infrastructure.api;

import com.shortener.application.RedirectResolver;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RedirectGetControllerTest {

	@InjectMocks
	private RedirectGetController redirectGetController;

	@Mock
	private RedirectResolver redirectResolver;

	@Test
	void shouldRedirect_whenHash() {
		String origin = "https://www.google.com";
		String hash = "Y8hF8Fh";

		when(this.redirectResolver.resolve(hash)).thenReturn(origin);
		ResponseEntity<?> response = this.redirectGetController.index(hash);

		assert response.getStatusCode().is3xxRedirection();
		assert Objects.requireNonNull(response.getHeaders().getLocation()).toString().equals(origin);
		verify(this.redirectResolver, times(1)).resolve(hash);
	}

}
