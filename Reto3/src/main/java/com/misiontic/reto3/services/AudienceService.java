package com.misiontic.reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.reto3.repository.AudienceRepository;
import com.misiontic.reto3.model.Audience;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audience) {
        if (audience.getId() == null) {
            return audienceRepository.save(audience);
        } else {
            Optional<Audience> e = audienceRepository.getAudience(audience.getId());
            if (e.isPresent()) {

                return audience;
            } else {
                return audienceRepository.save(audience);
            }
        }
    }

    public Audience update(Audience audience) {
        if (audience.getId() != null) {
            Optional<Audience> q = audienceRepository.getAudience(audience.getId());
            if (q.isPresent()) {
                if (audience.getName() != null) {
                    q.get().setName(audience.getName());
                    q.get().setOwner(audience.getOwner());
                    audience.setCapacity(audience.getCapacity());
                }
                audienceRepository.save(q.get());
                return q.get();
            } else {
                return audience;
            }
        } else {
            return audience;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Audience> audience = audienceRepository.getAudience(id);
        if (audience.isPresent()) {
            audienceRepository.delete(audience.get());
            flag = true;
        }
        return flag;

    }

}
