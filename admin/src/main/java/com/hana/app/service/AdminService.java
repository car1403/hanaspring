package com.hana.app.service;

import com.hana.app.data.dto.AdminDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService implements HanaService<String, AdminDto> {

    private final AdminRepository adminRepository;

    @Override
    public int add(AdminDto adminDto) throws Exception {
        return 0;
    }

    @Override
    public int del(String s) throws Exception {
        return 0;
    }

    @Override
    public int modify(AdminDto adminDto) throws Exception {
        return 0;
    }

    @Override
    public AdminDto get(String s) throws Exception {
        return adminRepository.selectOne(s);
    }

    @Override
    public List<AdminDto> get() throws Exception {
        return adminRepository.select();
    }
}
