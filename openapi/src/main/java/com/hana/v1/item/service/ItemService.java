package com.hana.v1.item.service;

import com.hana.common.dto.Response;
import com.hana.common.exception.NameDuplicateException;
import com.hana.common.exception.ErrorCode;
import com.hana.common.frame.HanaOpenService;
import com.hana.v1.item.dto.request.ItemRequestDto;
import com.hana.v1.item.dto.response.ItemResponseDto;
import com.hana.v1.item.entity.ItemEntity;
import com.hana.v1.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService implements HanaOpenService<ItemRequestDto, Long> {

    final ItemRepository itemRepository;
    private final Response response;


    @Override
    public ResponseEntity<?> get(Long aLong) {
//        ItemEntity item = itemRepository.findById(aLong).orElseThrow(()->new IllegalArgumentException("None"));
//        return response.success(new ItemResponseDto(item));
        //또는 직접 여기서 return
        Optional<ItemEntity> item = itemRepository.findById(aLong);
        // 에러정보 리턴 아래는 예외 발생
        if(item.isEmpty()){
            return response.fail("검색 내용이 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response.success(new ItemResponseDto(item.get()));

    }

    @Override
    public ResponseEntity<?> save(ItemRequestDto itemRequestDto) {
        Optional<ItemEntity> item =  itemRepository.findByName(itemRequestDto.getName());
        // 사용자 정의 예외 발생
        if( item.isPresent()){
            throw new NameDuplicateException("email duplicated", ErrorCode.NAME_DUPLICATION);
        }
        ItemEntity itemEntity = itemRepository.save(new ItemEntity(itemRequestDto));
        return response.success("성공했습니다.");
    }

    @Override
    public ResponseEntity<?> modify(ItemRequestDto itemRequestDto){
        ItemEntity item = itemRepository.findById(itemRequestDto.getId()).orElseThrow(()->new IllegalArgumentException("None"));
        item.update(itemRequestDto);
        itemRepository.save(item);
        return response.success("성공했습니다.");
    }

    @Override
    public ResponseEntity<?> delete(Long aLong)  {
        ItemEntity item = itemRepository.findById(aLong).orElseThrow(()->new IllegalArgumentException("None"));
        itemRepository.delete(item);
        return response.success("성공했습니다.");
    }

    @Override
    public ResponseEntity<?> getall() {
        return response.success(itemRepository.findAll().stream().map(ItemResponseDto::new).toList());
    }

}
