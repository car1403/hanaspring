package com.hana.app.service;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ItemDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustRepository;
import com.hana.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements HanaService<Integer, ItemDto> {

    final ItemRepository itemRepository;

    @Override
    public int add(ItemDto itemDto) throws Exception {
        return itemRepository.insert(itemDto);
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
