package com.shortener.application;

import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RedirectResolverTest {

	@InjectMocks
	private RedirectResolver redirectResolver;

	@Mock
	private UrlMappingRepository urlMappingRepository;

	@Test
	void shouldRedirect_whenHash() {
		String hash = "Y8hF8Fh";
		String origin = "https://www.google.com";
		UrlMapping urlMappingMock = new UrlMapping(origin, hash, LocalDateTime.now(), LocalDateTime.now().plusYears(1));
		when(this.urlMappingRepository.findByHash(any(Hash.class))).thenReturn(Optional.of(urlMappingMock));
		String originResolved = redirectResolver.resolve(hash);
		assert originResolved.equals(origin);
		verify(this.urlMappingRepository, times(1)).findByHash(new Hash(hash));
	}

}
