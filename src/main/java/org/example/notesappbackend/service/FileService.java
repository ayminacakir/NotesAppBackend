package org.example.notesappbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notesappbackend.exceptions.NotFoundException;
import org.example.notesappbackend.model.File;
import org.example.notesappbackend.repository.FileRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(value = "singleton")
@RequiredArgsConstructor
@Slf4j
public class FileService {

    private final FileRepository fileRepository;

    public File save(File file) {
        return fileRepository.save(file);
    }

    public File findById(Long id) {
        Optional<File> fileOptional = fileRepository.findById(id);

        if (fileOptional.isPresent()) {
            File file = fileOptional.get();
            return file;
        }
        else {
            throw new NotFoundException("Dosya bulunamadı.");
        }
    }

    public File delete(Long id) {
        Optional<File> fileOptional = fileRepository.findById(id);

        if (fileOptional.isPresent()) {
            File file = fileOptional.get();
            fileRepository.delete(file);
            return file;
        }
        else {
            throw new NotFoundException("Dosya bulunamadı.");
        }

    }
}