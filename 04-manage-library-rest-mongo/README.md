# Initialize MongoDb and PostgreSQL

	docker compose -f ./docker-compose.yml up -d
# Define Registration as Domain Object

	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
	
	@Document("registrations")
	public record Registration(
	        @Id String id,
	        @NotNull(message = "Product id is required") Integer productId,
	        String ticketCode,
	        @NotBlank(message = "Attendee name is required") String attendeeName) {
	}

# Modify RegistrationController to consume proper request object

	@PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticketCode = UUID.randomUUID().toString();

        return registrationRepository.save(new Registration(
                null, registration.productId(), ticketCode, registration.attendeeName()));
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        // Lookup the existing registration by ticket code
        String ticketCode = registration.ticketCode();
        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));

        // Only update the attendee name
        return registrationRepository.save(new Registration(
                existing.id(), existing.productId(), ticketCode, registration.attendeeName()));
    }

# Define RegistrationRepository to use MongoDB

	public interface RegistrationRepository extends MongoRepository<Registration, String> {
	
	    Optional<Registration> findByTicketCode(String ticketCode);
	
	    void deleteByTicketCode(String ticketCode);
	}

# Inspect Mongo DB on docker containier

    docker exec -it 03-database-spring-data-1-mongo-1 mongosh

