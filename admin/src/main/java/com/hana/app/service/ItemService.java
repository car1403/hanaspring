package com.hana.app.service;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.ItemRepository;
import com.hana.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements HanaService<Integer, ItemDto> {

    final ItemRepository itemRepository;
    @Value("${app.dir.uploadimgdir}")
    String imgdir;

    @Override
    public int add(ItemDto itemDto) throws Exception {
        int result = 0;
        result= itemRepository.insert(itemDto);
        FileUploadUtil.saveFile(itemDto.getImage(),imgdir);

        return result;
    }

    @Override
    public int del(Integer s) throws Exception {
        return itemRepository.delete(s);
    }

    @Override
    public int modify(ItemDto itemDto) throws Exception {
        return itemRepository.update(itemDto);
    }

    @Override
    public ItemDto get(Integer s) throws Exception {
        return itemRepository.selectOne(s);
    }

    @Override
    public List<ItemDto> get() throws Exception {
        return itemRepository.select();
    }
}
