import java.util.*;

public class ExamDCN {

    // -------------------------------------------------------------------------
    // Acceptable-answers map: primary answer -> list of all accepted forms
    private static final Map<String, List<String>> SYNONYMS = new LinkedHashMap<>();
    static {
        SYNONYMS.put("planning, analysis, design, implementation, maintenance",
                List.of("planning analysis design implementation maintenance",
                        "planning, analysis, design, implementation, maintenance"));
        SYNONYMS.put("insertion, update, deletion",
                List.of("insertion update deletion", "insertion, update, deletion",
                        "update, insertion, deletion", "deletion, update, insertion"));
        SYNONYMS.put("1nf, 2nf, 3nf",
                List.of("1nf 2nf 3nf", "1nf, 2nf, 3nf", "first second third normal form"));
        SYNONYMS.put("enterprise modeling, justification, scope indentification, requirements analysis",
                List.of("enterprise modeling justification scope identification requirements analysis",
                        "enterprise modeling, justification, scope identification, requirements analysis"));
        SYNONYMS.put(
                "preliminary modeling, enterprise comparison, detailed modeling, consistency check, repository population",
                List.of("preliminary modeling enterprise comparison detailed modeling consistency check repository population"));
        SYNONYMS.put("logical database design, physical databasse design and definition",
                List.of("logical database design physical database design and definition",
                        "logical database design, physical database design and definition"));
        SYNONYMS.put("coding and testing, documentation, installation",
                List.of("coding and testing documentation installation",
                        "coding and testing, documentation, installation"));
        SYNONYMS.put("performance monitoring, optimization, correction and recovery",
                List.of("performance monitoring optimization correction and recovery",
                        "performance monitoring, optimization, correction and recovery"));
        SYNONYMS.put("database management system",
                List.of("database management system", "dbms"));
        SYNONYMS.put("traditional file procession",
                List.of("traditional file procession", "traditional file processing"));
    }

    // -------------------------------------------------------------------------
    // All questions and answers as constants so we can always reset to full set
    private static final String[] ALL_QUESTIONS = {
            "These are computers that send requests to servers to retrieve information.",
            "These are computers that provide information to end devices.",
            "This type of server runs email server software and is accessed by client email programs.",
            "This type of server runs web server software and is accessed by web browsers.",
            "This type of server stores corporate and user files accessed by client devices.",
            "This is a small network design where devices connect directly without a central server.",
            "These are devices where a message originates or is received.",
            "These are devices that interconnect end devices like switches and routers.",
            "This refers to the medium that carries communication across a network.",
            "This network media uses electrical impulses within cables.",
            "This network media uses pulses of light within fibers.",
            "This network media uses electromagnetic waves.",
            "This is the hardware that connects a device to the network.",
            "This is the connector or outlet where network media is attached.",
            "This illustrates the physical layout of devices and cables.",
            "This illustrates virtual connections and IP addressing.",
            "This network type connects a few computers and the internet.",
            "This network type connects home or remote office users to a corporate network.",
            "This network type consists of many interconnected computers across locations.",
            "This network type connects millions of computers worldwide.",
            "This network interconnects devices in a limited geographical area.",
            "This network interconnects LANs over a wide geographical area.",
            "This is a worldwide collection of interconnected networks.",
            "This is a private internal network accessible only to an organization.",
            "This provides secure access to outsiders like partners or contractors.",
            "This network architecture characteristic provides redundancy to limit failures.",
            "This network architecture characteristic allows expansion without performance loss.",
            "This network architecture characteristic prioritizes critical traffic.",
            "This network architecture characteristic protects data and infrastructure.",
            "This ensures only authorized users can read data.",
            "This ensures data is not altered during transmission.",
            "This ensures reliable and timely access to data.",
            "This allows users to use personal devices on corporate networks.",
            "This refers to working with others over a network.",
            "This refers to communication using video calls over networks.",
            "This integrates network technology into everyday home devices.",
            "This uses electrical wiring for network connections.",
            "This provides internet using cellular technology.",
            "This allows storing and accessing data over the internet.",
            "This cloud type is available to the general public.",
            "This cloud type is dedicated to a specific organization.",
            "This cloud type combines multiple cloud types.",
            "This cloud type is built for a specific industry.",
            "This type of threat includes viruses, worms, and DoS attacks.",
            "This type of threat includes lost devices and malicious employees.",
            "This security solution includes antivirus and firewall for home networks.",
            "This security solution includes ACLs, VPNs, and IPS for enterprises.",
            "Iterate the four basic characteristics of network architecture.",
            "Iterate the CIA triad of network security.",
            "These are the physical components of a computer system.",
            "This acts as the interface between the user and the computer system.",
            "This manages communication between hardware and software.",
            "This type of OS allows interaction using graphical elements like icons and menus.",
            "This type of OS requires text-based commands to operate.",
            "This is a physical port used to directly access a network device for configuration.",
            "This provides a secure remote connection to a network device.",
            "This provides an insecure remote connection to a network device.",
            "These are programs used to connect to network devices via console or remote access.",
            "This Cisco IOS mode allows limited monitoring commands and is identified by >.",
            "This Cisco IOS mode allows full access and is identified by #.",
            "This configuration mode is used for general device settings.",
            "This configuration mode is used to configure console, SSH, and Telnet access.",
            "This configuration mode is used to configure specific interfaces.",
            "This command secures privileged EXEC mode with an encrypted password.",
            "This command encrypts all plaintext passwords in configuration files.",
            "This type of configuration file is stored in RAM and reflects current settings.",
            "This type of configuration file is stored in NVRAM and used during startup.",
            "This command saves the running configuration to startup configuration.",
            "This is the primary method for devices to identify each other on a network.",
            "This version of IP uses dotted-decimal notation.",
            "This version of IP uses hexadecimal notation and is 128 bits long.",
            "This is the router address used to access external networks.",
            "This must be configured on a switch to allow remote management.",
            "This allows automatic assignment of IP addresses to devices.",
            "Iterate the main components of a computer system.",
            "Iterate the access methods for network devices.",
            "Iterate the Cisco IOS configuration modes.",
            "Iterate the types of configuration files.",
            "These are the three essential elements of communication.",
            "This is the sender of a message in communication.",
            "This is the receiver of a message in communication.",
            "This is the medium that provides the path for communication.",
            "This is the process of converting information into another form for transmission.",
            "This is the process of interpreting encoded information at the destination.",
            "This ensures that a message follows a specific structure when transmitted.",
            "This refers to the size of a message that can be transmitted over a network.",
            "This manages the rate of data transmission between devices.",
            "This defines how long a device waits for a response.",
            "This determines when a device is allowed to send data.",
            "This type of communication is one-to-one.",
            "This type of communication is one-to-many but not all devices.",
            "This type of communication is one-to-all devices.",
            "These define a common set of rules for communication between devices.",
            "This protocol governs how web clients and servers interact.",
            "This protocol provides reliable delivery and flow control.",
            "This protocol is responsible for logical addressing and routing.",
            "This protocol delivers frames within the same LAN.",
            "This is a group of interrelated protocols working together.",
            "These layers focus on application and user interaction.",
            "These layers handle data movement and transmission.",
            "This is the most widely used protocol suite for networking.",
            "This reference model has seven layers.",
            "This reference model has four layers.",
            "This OSI layer handles process-to-process communication.",
            "This OSI layer ensures proper data representation.",
            "This OSI layer manages sessions between applications.",
            "This OSI layer segments and reassembles data.",
            "This OSI layer determines the best path for data.",
            "This OSI layer handles frame transmission over media.",
            "This OSI layer manages physical transmission of bits.",
            "This process breaks messages into smaller units.",
            "This process combines multiple data streams into one.",
            "This ensures segments are properly ordered.",
            "This is the PDU at the transport layer.",
            "This is the PDU at the network layer.",
            "This is the PDU at the data link layer.",
            "This is the PDU at the physical layer.",
            "This addressing is used at Layer 3 to identify devices globally.",
            "This addressing is used at Layer 2 for local delivery.",
            "This part of an IP address identifies the network.",
            "This part of an IP address identifies the specific device.",
            "This device acts as the gateway to other networks.",
            "This ensures data is delivered from source to destination using IP.",
            "This ensures data is delivered locally using MAC addresses.",
            "Iterate the protocol data units (PDUs) in order.",
            "Iterate the OSI layers from lowest to highest.",
            "Iterate the TCP/IP model layers in order.",
            "These are the three main areas of physical layer standards.",
            "This refers to the hardware devices and media that transmit signals.",
            "This converts bits into a recognizable format for transmission.",
            "This defines how bits are represented on the physical medium.",
            "This is the capacity of a medium to carry data.",
            "This measures how many bits can be transmitted per second.",
            "This is the time it takes for data to travel from source to destination.",
            "This measures the actual transfer rate of bits over time.",
            "This measures the usable data excluding overhead.",
            "This formula represents usable data transfer over time.",
            "This is the most common networking media using twisted copper wires.",
            "This type of cable provides better noise protection than UTP.",
            "This type of cable uses a central conductor and shielding.",
            "This type of media transmits data as pulses of light.",
            "This type of fiber uses a small core and lasers for long distances.",
            "This type of fiber uses a larger core and LEDs.",
            "This wireless media uses electromagnetic waves for communication.",
            "This limits wireless networks based on physical environment.",
            "This issue occurs when signals are disrupted by other devices.",
            "This wireless limitation means anyone within range can access signals.",
            "This means wireless devices share the medium and cannot transmit simultaneously.",
            "This wireless standard is used for WLANs.",
            "This wireless standard is used for short-range personal devices.",
            "This wireless standard provides broadband wireless access.",
            "This wireless standard is used for low-power IoT devices.",
            "This device connects wireless users to a wired network.",
            "This device allows hosts to connect wirelessly.",
            "This layer is responsible for communication between network interface cards.",
            "This layer encapsulates Layer 3 packets into frames.",
            "This layer performs error detection and discards corrupted frames.",
            "This sublayer communicates between upper-layer software and hardware.",
            "This sublayer handles data encapsulation and media access control.",
            "This is the process of removing the frame header and trailer.",
            "This is the process of adding a new frame header and trailer.",
            "This is the arrangement of network devices and their connections.",
            "This shows the physical connections of devices.",
            "This shows the logical connections using IP addressing.",
            "This WAN topology uses a direct connection between two endpoints.",
            "This WAN topology connects branch sites to a central site.",
            "This WAN topology connects all devices to each other.",
            "This LAN topology connects all devices to a central device.",
            "This LAN topology connects multiple star networks together.",
            "This LAN topology connects devices in a single line.",
            "This LAN topology connects devices in a circular manner.",
            "This allows only one device to transmit at a time.",
            "This allows devices to send and receive simultaneously.",
            "This access method requires devices to compete for the medium.",
            "This access method assigns specific time slots to devices.",
            "This protocol is used in legacy Ethernet for collision detection.",
            "This occurs when multiple devices transmit at the same time.",
            "This is the unit of data at the data link layer.",
            "This is the part of the frame containing addressing information.",
            "This contains the actual data being transmitted.",
            "This is used for error detection in frames.",
            "This is the physical address used for local delivery.",
            "This type of frame delivery is one-to-one.",
            "This type of frame delivery is one-to-all devices.",
            "This type of frame delivery is one-to-a-group.",
            "This device uses MAC addresses to forward frames.",
            "This table stores MAC addresses and associated ports.",
            "This happens when a switch sends a frame out all ports except the incoming one.",
            "This forwarding method checks the entire frame before sending.",
            "This forwarding method sends frames immediately without error checking.",
            "This forwarding method checks the first 64 bytes before forwarding.",
            "This buffering method assigns memory per port.",
            "This buffering method shares memory among all ports.",
            "This feature automatically detects cable type.",
    };

    private static final String[] ALL_ANSWERS = {
            "clients",
            "servers",
            "email server",
            "web server",
            "file server",
            "peer-to-peer network",
            "end devices",
            "intermediary network devices",
            "network media",
            "copper",
            "fiber optics",
            "wireless transmission",
            "network interface card",
            "physical port",
            "physical topology",
            "logical topology",
            "small home network",
            "soho",
            "medium to large network",
            "world wide network",
            "lan",
            "wan",
            "internet",
            "intranet",
            "extranet",
            "fault tolerance",
            "scalability",
            "quality of service",
            "security",
            "confidentiality",
            "integrity",
            "availability",
            "byod",
            "online collaboration",
            "video communications",
            "smart home technology",
            "powerline networking",
            "wireless broadband",
            "cloud computing",
            "public cloud",
            "private cloud",
            "hybrid cloud",
            "custom cloud",
            "external threats",
            "internal threats",
            "home network security",
            "enterprise network security",
            "fault tolerance, scalability, quality of service, security",
            "confidentiality, integrity, availability",
            "hardware",
            "shell",
            "kernel",
            "pc operating system",
            "cli-based networking os",
            "console",
            "ssh",
            "telnet",
            "terminal emulation programs",
            "user exec mode",
            "privileged exec mode",
            "global configuration mode",
            "line configuration mode",
            "interface configuration mode",
            "enable secret",
            "service password-encryption",
            "running-config",
            "startup-config",
            "copy running-config startup-config",
            "ip address",
            "ipv4",
            "ipv6",
            "default gateway",
            "switch virtual interface",
            "dhcp",
            "shell, kernel, hardware",
            "console, ssh, telnet",
            "global configuration mode, line configuration mode, interface configuration mode",
            "startup-config, running-config",
            "source, destination, channel",
            "source",
            "destination",
            "channel",
            "encoding",
            "decoding",
            "message formatting and encapsulation",
            "message size",
            "flow control",
            "response timeout",
            "access method",
            "unicast",
            "multicast",
            "broadcast",
            "protocols",
            "http",
            "tcp",
            "ip",
            "ethernet",
            "protocol suite",
            "higher layers",
            "lower layers",
            "tcp/ip",
            "osi model",
            "tcp/ip model",
            "application layer",
            "presentation layer",
            "session layer",
            "transport layer",
            "network layer",
            "data link layer",
            "physical layer",
            "segmenting",
            "multiplexing",
            "sequencing",
            "segment",
            "packet",
            "frame",
            "bits",
            "ip address",
            "mac address",
            "network portion",
            "host portion",
            "default gateway",
            "network layer delivery",
            "data link layer delivery",
            "data, segment, packet, frame, bits",
            "physical, data link, network, transport, session, presentation, application",
            "network access, internet, transport, application",
            "physical components, encoding, signaling",
            "physical components",
            "encoding",
            "signaling",
            "bandwidth",
            "digital bandwidth",
            "latency",
            "throughput",
            "goodput",
            "goodput = throughput - traffic overhead",
            "utp",
            "stp",
            "coaxial cable",
            "fiber optic",
            "single-mode fiber",
            "multimode fiber",
            "wireless media",
            "coverage area",
            "interference",
            "security",
            "shared medium",
            "wifi",
            "bluetooth",
            "wimax",
            "zigbee",
            "wireless access point",
            "wireless nic adapter",
            "data link layer",
            "data link layer",
            "data link layer",
            "logical link control",
            "media access control",
            "de-encapsulation",
            "encapsulation",
            "topology",
            "physical topology",
            "logical topology",
            "point-to-point",
            "hub and spoke",
            "mesh",
            "star",
            "extended star",
            "bus",
            "ring",
            "half-duplex",
            "full-duplex",
            "contention-based access",
            "controlled access",
            "csma/cd",
            "collision",
            "frame",
            "header",
            "data",
            "trailer",
            "mac address",
            "unicast",
            "broadcast",
            "multicast",
            "switch",
            "mac address table",
            "unknown unicast",
            "store-and-forward",
            "cut-through",
            "fragment free",
            "port-based memory",
            "shared memory",
            "auto-mdix",
    };

    // -------------------------------------------------------------------------
    public static void main(String[] args) {
        // Integrity check at startup
        if (ALL_QUESTIONS.length != ALL_ANSWERS.length) {
            System.err.printf("[ERROR] Mismatch: %d questions but %d answers. Fix before running.%n",
                    ALL_QUESTIONS.length, ALL_ANSWERS.length);
            return;
        }

        System.out.println("==========================================");
        System.out.println("       DCN Quiz - Networking Concepts     ");
        System.out.println("==========================================\n");
        System.out.println("Commands available during the quiz:");
        System.out.println("  'hint' -> reveal the first letter of the answer");
        System.out.println("  'skip' -> skip this question (counts as wrong)\n");

        Scanner scanner = new Scanner(System.in);

        // Outer loop: let the user start a full new session repeatedly
        boolean startNewSession;
        do {
            startNewSession = runSession(scanner);
        } while (startNewSession);

        System.out.println("\nThanks for studying! Good luck on your exam!");
        scanner.close();
    }

    // -------------------------------------------------------------------------
    /**
     * Runs one full quiz session (all questions + wrong-answer retry loop).
     * Returns true if the user wants to start a brand-new session afterward.
     */
    private static boolean runSession(Scanner scanner) {

        // Build working copies from the master arrays so we never mutate the originals
        List<String> questions = new ArrayList<>(Arrays.asList(ALL_QUESTIONS));
        List<String> answers   = new ArrayList<>(Arrays.asList(ALL_ANSWERS));

        // Shuffle initial order
        shufflePairs(questions, answers);

        System.out.printf("Starting quiz - %d questions total.%n%n", questions.size());

        int iteration = 0; // counts how many rounds we've done (including first)

        // ── First full round ────────────────────────────────────────────────
        RoundResult rr;
        iteration++;
        rr = runRound(scanner, questions, answers, iteration);

        // ── Wrong-answer retry loop ──────────────────────────────────────────
        while (!rr.missed.isEmpty()) {
            // Ask whether the user wants to retry wrong answers or start fresh
            System.out.println("You got " + rr.missed.size() + " question(s) wrong.");
            System.out.println("What would you like to do?");
            System.out.println("  [1] Focus on wrong answers only");
            System.out.println("  [2] Restart with ALL questions");
            System.out.println("  [3] End session");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("2")) {
                // Full restart within this session
                questions = new ArrayList<>(Arrays.asList(ALL_QUESTIONS));
                answers   = new ArrayList<>(Arrays.asList(ALL_ANSWERS));
                shufflePairs(questions, answers);
                iteration++;
                System.out.printf("%n--- Restarting with all %d questions (Round %d) ---%n%n",
                        questions.size(), iteration);
                rr = runRound(scanner, questions, answers, iteration);

            } else if (choice.equals("1")) {
                // Focus mode: only the questions that were wrong
                questions = new ArrayList<>();
                answers   = new ArrayList<>();
                for (String[] pair : rr.missed) {
                    questions.add(pair[0]);
                    answers.add(pair[1]);
                }
                shufflePairs(questions, answers);
                iteration++;
                System.out.printf("%n--- Round %d: Focusing on %d wrong question(s) ---%n%n",
                        iteration, questions.size());
                rr = runRound(scanner, questions, answers, iteration);

            } else if (choice.equals("3")) {
                break; // exit the retry loop without completing
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        // ── Session summary ──────────────────────────────────────────────────
        if (rr.missed.isEmpty()) {
            System.out.println("============================================");
            System.out.println("   You got everything correct!");
            System.out.printf("  Total rounds taken: %d%n", iteration);
            System.out.println("============================================\n");
        } else {
            System.out.println("============================================");
            System.out.printf("  Session ended after %d round(s).%n", iteration);
            System.out.printf("  %d question(s) were still unanswered correctly.%n",
                    rr.missed.size());
            System.out.println("============================================\n");
        }

        // ── Ask whether to start a brand-new session ─────────────────────────
        System.out.print("Would you like to start a brand-new quiz with ALL questions? (yes / no): ");
        String reply = scanner.nextLine().trim().toLowerCase();
        return reply.equals("yes") || reply.equals("y");
    }

    // -------------------------------------------------------------------------
    /** Holds the result of one quiz round. */
    private static class RoundResult {
        final int correct;
        final int skipped;
        final List<String[]> missed; // {question, answer} pairs

        RoundResult(int correct, int skipped, List<String[]> missed) {
            this.correct = correct;
            this.skipped = skipped;
            this.missed  = missed;
        }
    }

    // -------------------------------------------------------------------------
    /** Runs a single quiz round over the given question/answer lists. */
    private static RoundResult runRound(Scanner scanner,
                                        List<String> questions,
                                        List<String> answers,
                                        int roundNumber) {
        int correct = 0;
        int skipped = 0;
        List<String[]> missed = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("-- Round %d | Question %d / %d --------------------------------%n",
                    roundNumber, i + 1, questions.size());
            System.out.println(questions.get(i));

            final String correctAnswer = answers.get(i);
            final String questionText  = questions.get(i);
            boolean answered = false;

            while (!answered) {
                System.out.print("Answer: ");
                String userAnswer = scanner.nextLine().trim();

                if (userAnswer.equalsIgnoreCase("skip")) {
                    System.out.println("[SKIPPED] The answer was: " + correctAnswer + "\n");
                    skipped++;
                    missed.add(new String[]{questionText, correctAnswer});
                    answered = true;

                } else if (userAnswer.equalsIgnoreCase("hint")) {
                    String hint = correctAnswer.trim();
                    System.out.println("[HINT] The answer starts with '" + hint.charAt(0) + "'" +
                            (hint.length() > 1 ? " and has " + hint.length() + " character(s)." : "."));

                } else if (isCorrect(userAnswer, correctAnswer)) {
                    System.out.println("Correct!\n");
                    correct++;
                    answered = true;

                } else {
                    System.out.println("Wrong! The answer is: " + correctAnswer + "\n");
                    missed.add(new String[]{questionText, correctAnswer});
                    answered = true;
                }
            }
        }

        // Round score summary
        int total = questions.size();
        double pct = (double) correct / total * 100.0;
        System.out.println("============================================");
        System.out.printf("  Round %d Score: %d / %d  (%.1f%%)%n", roundNumber, correct, total, pct);
        if (skipped > 0)
            System.out.printf("  Skipped: %d%n", skipped);
        System.out.printf("  Result: %s%n", pct >= 75 ? "PASSED" : "FAILED (passing mark: 75%)");
        System.out.println("============================================\n");

        if (!missed.isEmpty()) {
            System.out.println("Questions you missed this round:");
            for (String[] entry : missed) {
                System.out.println("  - " + entry[0]);
                System.out.println("    Answer: " + entry[1]);
            }
            System.out.println();
        }

        return new RoundResult(correct, skipped, missed);
    }

    // -------------------------------------------------------------------------
    /** Fisher-Yates shuffle on two parallel lists. */
    private static void shufflePairs(List<String> questions, List<String> answers) {
        Random rand = new Random();
        for (int i = questions.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Collections.swap(questions, i, j);
            Collections.swap(answers,   i, j);
        }
    }

    // -------------------------------------------------------------------------
    private static boolean isCorrect(String userAnswer, String expected) {
        String normalUser     = normalize(userAnswer);
        String normalExpected = normalize(expected);

        if (normalUser.equals(normalExpected)) return true;

        List<String> alternatives = SYNONYMS.get(normalExpected);
        if (alternatives != null) {
            for (String alt : alternatives) {
                if (normalUser.equals(normalize(alt))) return true;
            }
        }
        return false;
    }

    private static String normalize(String s) {
        return s.toLowerCase().trim().replaceAll("\\s+", " ");
    }
}