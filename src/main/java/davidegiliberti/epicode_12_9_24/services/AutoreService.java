package davidegiliberti.epicode_12_9_24.services;

import davidegiliberti.epicode_12_9_24.entities.Autore;
import davidegiliberti.epicode_12_9_24.exceptions.NotFoundExceptions;
import davidegiliberti.epicode_12_9_24.repositories.AutoreRepository;
import davidegiliberti.epicode_12_9_24.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoreService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Autore saveAutore(Autore body) {
        return autoreRepository.save(body);
    }

    public Autore findById(int autoreId) {
        return autoreRepository.findById(autoreId).orElseThrow(() -> new NotFoundExceptions(autoreId));
    }

    public Autore update(int autoreId, Autore autoreAggiornato) {
        Autore autore = findById(autoreId);

        autore.setNome(autoreAggiornato.getNome());

        autore.setCognome(autoreAggiornato.getCognome());

        autore.setEmail(autoreAggiornato.getEmail());

        autore.setDataDiNascita(autoreAggiornato.getDataDiNascita());

        autore.setAvatar(autoreAggiornato.getAvatar());

        return autoreRepository.save(autore);
    }

    public void delete(int autoreId) {
        Autore autore = findById(autoreId);
        autoreRepository.delete(autore);
    }
}
