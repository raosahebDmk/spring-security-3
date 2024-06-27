

Spring boot 3.0

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterchain(HttpSecurity http)throws Exception
	{
		return http.authorizeHttpRequests(registry ->{
			registry.requestMatchers("/home").permitAll();
			registry.requestMatchers("/admin/**").hasRole("ADMIN");
			registry.requestMatchers("/user/**").hasRole("USER");
			registry.anyRequest().authenticated();
		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.build();
		
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails normalUser = User.builder()
				.username("rkd")
				.password("$2a$12$.ooTB8fPheHlaG3zOhykTe.nAqaUNs7J5cZy.ecuEbBQ9tC6phe2m")
				.roles("USER")
				.build();
		
		UserDetails adminUser = User.builder()
				.username("admin")
				.password("$2a$12$TsBVj9D1I1kL3DHVdwaGj.1ObSvoLoHAE2mCcyYbBq7.JhfofN2Qm")
				.roles("ADMIN")
				.build();
		
		return  new InMemoryUserDetailsManager(normalUser, adminUser);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
![Uploading image.png…]()

