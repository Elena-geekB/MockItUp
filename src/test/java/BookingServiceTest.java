package com.max;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    @Test
    void testBookingSuccess() throws CantBookException {
        Logger logger = Logger.getLogger(BookingService.class.getName());
        BookingService service = spy(new BookingService());

        LocalDateTime from = LocalDateTime.of(2024, 12, 15, 10, 0);
        LocalDateTime to = LocalDateTime.of(2024, 12, 15, 11, 0);

        doReturn(true).when(service).checkTimeInBD(from, to);
        doReturn(true).when(service).createBook("user123", from, to);

        boolean result = service.book("user123", from, to);

        verify(service).checkTimeInBD(from, to);
        verify(service).createBook("user123", from, to);
        assertTrue(result);
    }

    @Test
    void testBookingFailure() {
        Logger logger = Logger.getLogger(BookingService.class.getName());
        BookingService service = spy(new BookingService());

        LocalDateTime from = LocalDateTime.of(2024, 12, 15, 10, 0);
        LocalDateTime to = LocalDateTime.of(2024, 12, 15, 11, 0);

        doReturn(false).when(service).checkTimeInBD(from, to);

        assertThrows(CantBookException.class, () -> service.book("user123", from, to));
        verify(service).checkTimeInBD(from, to);
        verify(service, never()).createBook(anyString(), any(), any());
    }
}
