package com.max;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class BookingService {
    private static final Logger logger = Logger.getLogger(BookingService.class.getName());

    public boolean book(String userId, LocalDateTime from, LocalDateTime to) throws CantBookException {
        logger.info(String.format("Booking request received: userId=%s, from=%s, to=%s", userId, from, to));

        if (checkTimeInBD(from, to)) {
            boolean result = createBook(userId, from, to);
            logger.info("Booking successful: " + result);
            return result;
        }

        logger.warning("Booking failed: slot unavailable.");
        throw new CantBookException();
    }

    public boolean checkTimeInBD(LocalDateTime from, LocalDateTime to) {
        // Not implemented
        return false;
    }

    public boolean createBook(String userId, LocalDateTime from, LocalDateTime to) {
        // Not implemented
        return false;
    }
}
