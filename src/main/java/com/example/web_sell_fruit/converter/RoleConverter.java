package com.example.web_sell_fruit.converter;


import com.example.web_sell_fruit.entity.Role;
import com.example.web_sell_fruit.models.RoleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    private ModelMapper modelMapper;

    public RoleConverter() {
        modelMapper = new ModelMapper();
    }

    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);

        return roleDTO;
    }

    public Role toEntity(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);

        return role;
    }
}
