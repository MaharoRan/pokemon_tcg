package fr.efrei.pokemon_tcg.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService {

	private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
	private static final String AUTH_TOKEN = "Z5S3JagDxq1XIhTIjA2up6yNJSQTjTkAS05kf0/Pkhk=";

	public static Authentication getAuthentication(HttpServletRequest request) {
		String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
		if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
			throw new BadCredentialsException("Invalid API Key");
		}

		return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
	}
}