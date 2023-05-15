package TestMockito;
import com.inventory.Inventory.exception.RolNotFoundException;
import com.inventory.Inventory.model.Roles;
import com.inventory.Inventory.repository.RolesRepository;
import com.inventory.Inventory.service.RolesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
public class RolesServiceImplTest {

    @Mock
    private RolesRepository rolesRepository;

    @InjectMocks
    private RolesServiceImpl rolesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllRoles() {
        List<Roles> rolesList = new ArrayList<>();
        Roles roles = new Roles();
        roles.setId_rol(1);
        roles.setRol("Admin");
        rolesList.add(roles);

        when(rolesRepository.findAll()).thenReturn(rolesList);

        List<Roles> result = rolesService.getAllRoles();
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getRol(), "Admin");
    }

    @Test
    public void testGetRolesByID() {
        Roles roles = new Roles();
        roles.setId_rol(1);
        roles.setRol("Admin");

        when(rolesRepository.findById(1)).thenReturn(Optional.of(roles));

        Roles result = rolesService.getRolesByID(1);
        assertEquals(result.getRol(), "Admin");

        assertThrows(RolNotFoundException.class, () -> {
            rolesService.getRolesByID(2);
        });
    }

    @Test
    public void testSaveRoles() {
        Roles roles = new Roles();
        roles.setRol("Admin");

        when(rolesRepository.save(any(Roles.class))).thenReturn(roles);

        String result = rolesService.saveRoles(roles);
        assertEquals(result, "New rol has added");
    }

    @Test
    public void testUpdateRoles() {
        Roles oldRol = new Roles();
        oldRol.setId_rol(1);
        oldRol.setRol("Admin");

        Roles newRol = new Roles();
        newRol.setId_rol(1);
        newRol.setRol("SuperAdmin");

        when(rolesRepository.findById(1)).thenReturn(Optional.of(oldRol));
        when(rolesRepository.save(any(Roles.class))).thenReturn(newRol);

        Roles result = rolesService.updateRoles(newRol, 1);
        assertEquals(result.getRol(), "SuperAdmin");

        assertThrows(RolNotFoundException.class, () -> {
            rolesService.updateRoles(newRol, 2);
        });
    }

    @Test
    public void testDeleteRoles() {
        when(rolesRepository.existsById(1)).thenReturn(true);

        String result = rolesService.deleteRoles(1);
        assertEquals(result, "Rol with id 1 has been deleted success");

        assertThrows(RolNotFoundException.class, () -> {
            rolesService.deleteRoles(2);
        });
    }
}

