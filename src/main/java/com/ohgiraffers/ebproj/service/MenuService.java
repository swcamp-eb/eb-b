package com.ohgiraffers.ebproj.service;

import com.ohgiraffers.ebproj.dto.MenuDTO;
import com.ohgiraffers.ebproj.entity.Menu;
import com.ohgiraffers.ebproj.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu selectedMenu = menuRepository.findById(menuCode).get();

        return modelMapper.map(selectedMenu, MenuDTO.class);
    }
}
