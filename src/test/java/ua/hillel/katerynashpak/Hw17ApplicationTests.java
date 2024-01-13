package ua.hillel.katerynashpak;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class Hw17ApplicationTests {
    @InjectMocks
    private Hw17Application hw17Application;

    @Test
    void onStartup() {
        assertNotNull(hw17Application);
    }

}
