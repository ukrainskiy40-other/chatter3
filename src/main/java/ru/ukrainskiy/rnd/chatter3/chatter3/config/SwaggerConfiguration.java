package ru.ukrainskiy.rnd.chatter3.chatter3.config;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

@Configuration
public class SwaggerConfiguration {

	@Value("${chatter.back.version: 0.0.1}")
	private String appVersion;
	@Value("${server.domain: http://localhost:8080}")
	private String serverUrl;

	@Bean
	public OpenAPI chatterOpenApi() {
		return new OpenAPI().addServersItem(new Server().url(serverUrl));
	}

	@Bean
	public GroupedOpenApi chatterApi() {
		return newGroupedOpenApi("1. Chatter3 API", "Chatter3 API", "Chatter3 API",
				frontendPaths());
	}

	private String[] frontendPaths() {
		return new String[] {
				"/api/v1/front/**",
				"/api/v1/user/**",
		};
	}

	private GroupedOpenApi newGroupedOpenApi(String groupName, String title, String description, String[] paths) {
		return GroupedOpenApi.builder().addOpenApiCustomizer(new ChatterOpenApiCustomiser(title, description))
				.group(groupName)
				.packagesToScan("ru.ukrainskiy.rnd.chatter3.chatter3.integration")
				.pathsToMatch(paths)
				.build();
	}

	@RequiredArgsConstructor
	private class ChatterOpenApiCustomiser implements OpenApiCustomizer {
		private final String title;
		private final String description;

		@Override
		public void customise(OpenAPI openApi) {
			openApi
					.info(new Info().title(title)
							.description(description)
							.version(appVersion)
							.termsOfService(serverUrl)
							.license(new License()
									.name("Apache License Version 2.0")
									.url("https://apache.org/licenses/LICENSE-2.0"))
							.contact(new Contact()
									.name("Developers")
									.url(serverUrl)
									.email("ukrainsky@kaluga.ru")));
		}
	}

}
