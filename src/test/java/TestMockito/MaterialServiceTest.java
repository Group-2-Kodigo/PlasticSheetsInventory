package TestMockito;

import com.inventory.Inventory.exception.MaterialNotFoundException;
import com.inventory.Inventory.model.Materials;
import com.inventory.Inventory.repository.MaterialRepository;
import com.inventory.Inventory.service.MaterialServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MaterialServiceTest {
    @Mock
    private MaterialRepository materialRepository;

    @InjectMocks
    private MaterialServiceImpl materialService;

    @Test
    public void testGetAllMaterial() {
        // arrange
        List<Materials> materials = new ArrayList<>();
        Materials materials1 = new Materials();
        materials1.setId_material(1);
        materials1.setMaterials("Material 1");
        Materials materials2 = new Materials();
        materials2.setId_material(2);
        materials2.setMaterials("Material 2");
        materials.add(materials1);
        materials.add(materials2);
        when(materialRepository.findAll()).thenReturn(materials);

        // act
        List<Materials> result = materialService.getAllMaterial();

        // assert
        assertEquals(2, result.size());
        assertEquals("Material 1", result.get(0).getMaterials());
        assertEquals("Material 2", result.get(1).getMaterials());
    }

    @Test
    public void testGetMaterialById() {
        // arrange
        Materials materials = new Materials();
        materials.setId_material(1);
        materials.setMaterials("Material 1");
        when(materialRepository.findById(1)).thenReturn(Optional.of(materials));

        // act
        Materials result = materialService.getMaterialById(1);

        // assert
        assertEquals("Material 1", result.getMaterials());
    }

    @Test
    public void testGetMaterialByIdNotFound() {
        // arrange
        when(materialRepository.findById(1)).thenReturn(Optional.empty());

        // assert
        assertThrows(MaterialNotFoundException.class, () -> {
            // act
            materialService.getMaterialById(1);
        });
    }

    @Test
    public void testSaveMaterial() {
        // arrange
        Materials materials = new Materials();
        materials.setMaterials("Material 1");
        when(materialRepository.save(materials)).thenReturn(materials);

        // act
        Materials result = materialService.saveMaterial(materials);

        // assert
        assertEquals("Material 1", result.getMaterials());
    }

    @Test
    public void testUpdateMaterial() {
        // arrange
        Materials oldMaterials = new Materials();
        oldMaterials.setId_material(1);
        oldMaterials.setMaterials("Material 1");
        Materials newMaterials = new Materials();
        newMaterials.setId_material(1);
        newMaterials.setMaterials("New Material 1");
        when(materialRepository.findById(1)).thenReturn(Optional.of(oldMaterials));
        when(materialRepository.save(oldMaterials)).thenReturn(newMaterials);
                // act
                Materials result = materialService.updateMaterial(newMaterials, 1);

        // assert
        assertEquals("New Material 1", result.getMaterials());
    }

    @Test
    public void testUpdateMaterialNotFound() {
        // arrange
        Materials newMaterials = new Materials();
        newMaterials.setId_material(1);
        newMaterials.setMaterials("New Material 1");
        when(materialRepository.findById(1)).thenReturn(Optional.empty());

        // assert
        assertThrows(MaterialNotFoundException.class, () -> {
            // act
            materialService.updateMaterial(newMaterials, 1);
        });
    }

    @Test
    public void testDeleteMaterial() {
        // arrange
        Materials materials = new Materials();
        materials.setId_material(1);
        materials.setMaterials("Material 1");
        when(materialRepository.existsById(1)).thenReturn(true);

        // act
        String result = materialService.deleteMaterial(1);

        // assert
        assertEquals("Material with id 1 has been deleted success", result);
        verify(materialRepository, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteMaterialNotFound() {
        // arrange
        when(materialRepository.existsById(1)).thenReturn(false);

        // assert
        assertThrows(MaterialNotFoundException.class, () -> {
            // act
            materialService.deleteMaterial(1);
        });
        verify(materialRepository, never()).deleteById(1);
    }


}
