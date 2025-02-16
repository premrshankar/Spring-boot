# Initialize MongoDb and PostgreSQL

	docker compose -f ./docker-compose.yml up -d

# Define Event as Domain Object

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organizer_id", referencedColumnName = "id", nullable = false)
    private Organizer organizer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venue_id", referencedColumnName = "id", nullable = false)
    private Venue venue;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

# Redesign Event Repository to get it from database
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizerId(int organizerId);
}
# Define Organizer as Domain Object

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;
# Redesign Organizer Repository to get it from database
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
}

# Define Product as Domain Object

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int eventId;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;
    
# Redesign Product Repository to get it from database
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByEventId(int eventId);
}


# Define Venue as Domain Object

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String country;

# Redesign VenueRepository to get it from database
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
}

# Redesign Registration document object
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("registrations")
public record Registration(
        @Id String id,
        @NotNull(message = "Product id is required") Integer productId,
        String ticketCode,
        @NotBlank(message = "Attendee name is required") String attendeeName) {
}


# Redesign RegistrationController

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
    
# Redesign RegistrationRepository object

public interface RegistrationRepository extends MongoRepository<Registration, String> {

    Optional<Registration> findByTicketCode(String ticketCode);

    void deleteByTicketCode(String ticketCode);
}
