package TestMockito;

import com.inventory.Inventory.exception.MaterialNotFoundException;
import com.inventory.Inventory.model.Material;
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
        List<Material> materials = new ArrayList<>();
        Material material1 = new Material();
        material1.setId_material(1);
        material1.setMaterials("Material 1");
        Material material2 = new Material();
        material2.setId_material(2);
        material2.setMaterials("Material 2");
        materials.add(material1);
        materials.add(material2);
        when(materialRepository.findAll()).thenReturn(materials);

        // act
        List<Material> result = materialService.getAllMaterial();

        // assert
        assertEquals(2, result.size());
        assertEquals("Material 1", result.get(0).getMaterials());
        assertEquals("Material 2", result.get(1).getMaterials());
    }

    @Test
    public void testGetMaterialById() {
        // arrange
        Material material = new Material();
        material.setId_material(1);
        material.setMaterials("Material 1");
        when(materialRepository.findById(1)).thenReturn(Optional.of(material));

        // act
        Material result = materialService.getMaterialById(1);

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
        Material material = new Material();
        material.setMaterials("Material 1");
        when(materialRepository.save(material)).thenReturn(material);

        // act
        Material result = materialService.saveMaterial(material);

        // assert
        assertEquals("Material 1", result.getMaterials());
    }

    @Test
    public void testUpdateMaterial() {
        // arrange
        Material oldMaterial = new Material();
        oldMaterial.setId_material(1);
        oldMaterial.setMaterials("Material 1");
        Material newMaterial = new Material();
        newMaterial.setId_material(1);
        newMaterial.setMaterials("New Material 1");
        when(materialRepository.findById(1)).thenReturn(Optional.of(oldMaterial));
        when(materialRepository.save(oldMaterial)).thenReturn(newMaterial);
                // act
                Material result = materialService.updateMaterial(newMaterial, 1);

        // assert
        assertEquals("New Material 1", result.getMaterials());
    }

    @Test
    public void testUpdateMaterialNotFound() {
        // arrange
        Material newMaterial = new Material();
        newMaterial.setId_material(1);
        newMaterial.setMaterials("New Material 1");
        when(materialRepository.findById(1)).thenReturn(Optional.empty());

        // assert
        assertThrows(MaterialNotFoundException.class, () -> {
            // act
            materialService.updateMaterial(newMaterial, 1);
        });
    }

    @Test
    public void testDeleteMaterial() {
        // arrange
        Material material = new Material();
        material.setId_material(1);
        material.setMaterials("Material 1");
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
