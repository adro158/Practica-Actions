import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mycompany.vib.Usuario;

public class UsuarioTest {

    @Test
    void crearUsuarioValido() {
        Usuario u = new Usuario("Ana", 25);
        assertEquals("Ana", u.getNombre());
        assertEquals(25, u.getEdad());
        assertTrue(u.isActivo());
    }

    @Test
    void usuarioNuevoEstaActivo() {
        Usuario u = new Usuario("Luis", 30);
        assertTrue(u.isActivo());
    }

    @Test
    void desactivarUsuarioCambiaEstado() {
        Usuario u = new Usuario("Maria", 40);
        u.desactivar();
        assertFalse(u.isActivo());
    }

    @Test
    void usuarioMayorDeEdad() {
        Usuario u = new Usuario("Pedro", 18);
        assertTrue(u.esMayorDeEdad());
    }

    @Test
    void usuarioMenorDeEdad() {
        Usuario u = new Usuario("Laura", 17);
        assertFalse(u.esMayorDeEdad());
    }

    @Test
    void nombreVacioLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("", 20);
        });
    }

    @Test
    void nombreNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(null, 20);
        });
    }

    @Test
    void edadNegativaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Carlos", -1);
        });
    }
}