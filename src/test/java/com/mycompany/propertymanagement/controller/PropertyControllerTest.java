package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController; // mockito is going to create proxy object of propertyController
    @Mock  //mockito will give memory to property Service
    private PropertyService propertyService;
    @Test
    @DisplayName("Test Success Scenario Property Save ")

    void testSaveProperty_Success()
    {
        PropertyDTO dto=new PropertyDTO();
        dto.setTitle("Dummy Title");
        PropertyDTO savedProperty=new PropertyDTO();
        savedProperty.setId(1L);
        savedProperty.setTitle(dto.getTitle());
//        fake call don't make actual call
        Mockito.when(propertyService.saveProperty(dto)).thenReturn(savedProperty);
        ResponseEntity<PropertyDTO> responseEntity= propertyController.saveProperty(dto);
        Assertions.assertNotNull(responseEntity.getBody().getId());
        assertEquals(HttpStatus.CREATED.value(),responseEntity.getStatusCodeValue());


    }

    @Test
    @DisplayName("Test Success Scenario for Fetching All Properties")
    void testGetProperties(){
        List<PropertyDTO> propertyList = new ArrayList<>();
        PropertyDTO dto = new PropertyDTO();
        dto.setId(1L);
        dto.setTitle("Dummy Property");
        propertyList.add(dto);

        //Do not make the actual call for propertyService.getAllProperties() inside controller rather return dummy List<PropertyDTO> in the controller
        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyList);
        ResponseEntity<List<PropertyDTO>> responseEntity = propertyController.getAllProperties();
        assertEquals(1, responseEntity.getBody().size());
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    }
    @Test
    @DisplayName("Test Success Scenario for updating only price of the property")
    void testUpdatePropertyPrice(){

        PropertyDTO dto = new PropertyDTO();
        dto.setPrice(67676.78);

        Mockito.when(propertyService.updatePropertyPrice(Mockito.any(), Mockito.anyLong())).thenReturn(dto);
        ResponseEntity<PropertyDTO> responseEntity = propertyController.updatePropertyPrice(dto, 1L);

        assertEquals(67676.78, responseEntity.getBody().getPrice());
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    }

}
