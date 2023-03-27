package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO)
    {
        PropertyEntity pe=new PropertyEntity();

        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());
        return  pe;
    }
    //entityToDTO converter
    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity)
    {
        PropertyDTO de=new PropertyDTO();
        de.setId(propertyEntity.getId());
        de.setTitle(propertyEntity.getTitle());
        de.setDescription(propertyEntity.getDescription());
        de.setOwnerName(propertyEntity.getOwnerName());
        de.setOwnerEmail(propertyEntity.getOwnerEmail());
        de.setPrice(propertyEntity.getPrice());
        de.setAddress(propertyEntity.getAddress());
        return  de;
    }
}
