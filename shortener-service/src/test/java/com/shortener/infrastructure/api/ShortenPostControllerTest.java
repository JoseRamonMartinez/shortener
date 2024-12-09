package com.shortener.infrastructure.api;

import com.shortener.application.ShorUrlCreator;
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
class ShortenPostControllerTest {

	@InjectMocks
	private ShortenPostController shortenPostController;

	@Mock
	private ShorUrlCreator shorUrlCreator;

	@Test
	void shouldShortenUrl_whenUrl() {

		String hash = "Y8hF8Fh";
		ShortenRequest request = new ShortenRequest("https://www.google.com");
		when(this.shorUrlCreator.create(request.getOrigin())).thenReturn(hash);


		ResponseEntity<ShortenResponse> response = this.shortenPostController.index(request);

		assert response.getStatusCode().is2xxSuccessful();
		assert Objects.requireNonNull(response.getBody()).gethash().equals(hash);
		verify(this.shorUrlCreator, times(1)).create(request.getOrigin());
	}

}
