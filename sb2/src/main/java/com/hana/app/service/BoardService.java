package com.hana.app.service;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.BoardDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.AddrRepository;
import com.hana.app.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService implements HanaService<Integer, BoardDto> {

    final BoardRepository boardRepository;

    @Override
    public int add(BoardDto boardDto) throws Exception {
        return boardRepository.insert(boardDto);
    }

    @Override
    public int del(Integer s) throws Exception {
        return boardRepository.delete(s);
    }

    @Override
    public int modify(BoardDto boardDto) throws Exception {
        return boardRepository.update(boardDto);
    }

    @Override
    public BoardDto get(Integer s) throws Exception {
        return boardRepository.selectOne(s);
    }

    @Override
    public List<BoardDto> get() throws Exception {
        return boardRepository.select();
    }
    public List<BoardDto> getRank() throws Exception {
        return boardRepository.getRank();
    }

    public int cntUpdate(Integer id) throws Exception {
        return boardRepository.cntUpdate(id);
    }

}
