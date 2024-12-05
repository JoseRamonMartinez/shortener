package com.shortener.infrastructure.api;

import com.shortener.application.RedirectResolver;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.mockito.Mockito.*;

@SpringBootTest
class RedirectGetControllerTest {

	@InjectMocks
	private RedirectGetController redirectGetController;

	@Mock
	private RedirectResolver redirectResolver;

	@Test
	void shouldRedirect_whenHash() {
		String originalUrl = "https://www.google.com";
		String hash = "Y8hF8Fh";

		when(this.redirectResolver.resolve(hash)).thenReturn(originalUrl);
		ResponseEntity<?> response = this.redirectGetController.index(hash);

		assert response.getStatusCode().is3xxRedirection();
		assert Objects.requireNonNull(response.getHeaders().getLocation()).toString().equals(originalUrl);
		verify(this.redirectResolver, times(1)).resolve(hash);
	}

}
