package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private UserRepository userRepository;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        // conversion propertyDTO to propertyEntity
        PropertyEntity pe=propertyConverter.convertDTOtoEntity(propertyDTO);
        Optional<UserEntity> optUe= userRepository.findById(propertyDTO.getUserId());
        if(optUe.isPresent())
        {
            pe.setUserEntity(optUe.get());
            pe= propertyRepository.save(pe);
            propertyDTO=propertyConverter.convertEntityToDTO(pe);
        } else {
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("USER_ID_NOT_EXIST");
            errorModel.setMessage("User Does not exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }


        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProperty =( List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList=new ArrayList<>();
        for (PropertyEntity pe:listOfProperty)
        {
         PropertyDTO dto=propertyConverter.convertEntityToDTO(pe);
         propList.add(dto);
        }
        return propList;
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAllByUserEntityId(userId);
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe : listOfProps){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }


    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
       Optional<PropertyEntity> optionalEntity= propertyRepository.findById(propertyId);
       PropertyDTO dto=null;
       if(optionalEntity.isPresent()){
           PropertyEntity pe=optionalEntity.get();  //data from database
           pe.setTitle(propertyDTO.getTitle());
           pe.setDescription(propertyDTO.getDescription());
           pe.setPrice(propertyDTO.getPrice());
           pe.setAddress(propertyDTO.getAddress());
           dto=propertyConverter.convertEntityToDTO(pe);
           propertyRepository.save(pe);
       }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalEntity= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optionalEntity.isPresent()){
            PropertyEntity pe=optionalEntity.get();  //data from database
            pe.setDescription(propertyDTO.getDescription());
            dto=propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalEntity= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optionalEntity.isPresent()){
            PropertyEntity pe=optionalEntity.get();  //data from database
            pe.setPrice(propertyDTO.getPrice());
            dto=propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
    propertyRepository.deleteById(propertyId);
    }
}
