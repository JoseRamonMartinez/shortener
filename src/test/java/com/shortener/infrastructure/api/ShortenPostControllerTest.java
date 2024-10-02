package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.mockito.Mockito.*;

@SpringBootTest
class ShortenPostControllerTest {

	@InjectMocks
	private ShortenPostController shortenPostController;

	@Mock
	private ShorUrlCreator shorUrlCreator;

	@Test
	void shouldShortenUrl_whenUrl() {

		String hash = "Y8hF8Fh";
		ShortenRequest request = new ShortenRequest("https://www.google.com");
		when(this.shorUrlCreator.create(request.getUrl())).thenReturn(hash);


		ResponseEntity<ShortenResponse> response = shortenPostController.index(request);

		assert response.getStatusCode().is2xxSuccessful();
		assert Objects.requireNonNull(response.getBody()).getUrl().equals(hash);
		verify(this.shorUrlCreator, times(1)).create(request.getUrl());
	}

}
