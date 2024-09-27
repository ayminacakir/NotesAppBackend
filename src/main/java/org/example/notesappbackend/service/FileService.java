package org.example.notesappbackend.service;

import org.example.notesappbackend.Exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notesappbackend.model.File;
import org.example.notesappbackend.repository.FileRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service /* @Scope(value = "singleton")
Singleton kapsamı (scope), bu sınıfın Spring bağlamında yalnızca bir kez oluşturulacağını belirtir.
Bu demektir ki, uygulama boyunca bu sınıftan sadece bir tane FileService nesnesi oluşturulacak ve her yerde aynı nesne kullanılacaktır.*/
@Scope(value = "singleton")
@RequiredArgsConstructor
@Slf4j
public class FileService {
    private final FileRepository fileRepository;

    public File save(File file) {
        return fileRepository.save(file);
    }
    public File findById(Long id){
        Optional<File> fileOptional = fileRepository.findById(id);

        if (fileOptional.isPresent()){
            File file = fileOptional.get();
            return file;
        } /*Optional<File> fileOptional = fileRepository.findById(id);: Veritabanında, bu id ile bir dosya aranır. Eğer dosya bulunursa, sonuç Optional türünde döndürülür.
Optional, null güvenliği sağlayan bir veri tipidir. Yani, sonuç null ise doğrudan nullPointerException hatası almazsın, onun yerine opsiyonel olarak boş olup olmadığını kontrol edebilirsin.*/
    else {
        throw new NotFoundException("Dosya bulunamadı.");
        }
    }
    public File delete(Long id){
        Optional<File> fileOptional = fileRepository.findById(id);

        if(fileOptional.isPresent()){
            File file = fileOptional.get();
            fileRepository.delete(file);
            return file;
        }
        else {
            throw new NotFoundException("Dosya bulunamadı.");
        }

    }

}
