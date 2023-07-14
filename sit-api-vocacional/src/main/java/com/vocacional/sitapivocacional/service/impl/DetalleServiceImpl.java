package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.DetallePago;
import com.vocacional.sitapivocacional.repository.DetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServiceImpl implements DetalleService{

    private DetalleRepository detalleRepository;

    public DetalleServiceImpl(DetalleRepository detalleRepository) {
        this.detalleRepository = detalleRepository;}

    @Override
    public DetallePago addDetalle(DetallePago oDP) {
        return this.detalleRepository.save(oDP);
    }

    @Override
    public DetallePago getDetalle(long id) {
        Optional<DetallePago> optionalDetalle = this.detalleRepository.findById(id);
        return optionalDetalle.orElse(null);
    }

    @Override
    public DetallePago updateDetalle(DetallePago oDP) {
        return detalleRepository.save(oDP);
    }

    @Override
    public void deleteDetalleId(long id) {
        this.detalleRepository.deleteById(id);
    }

    @Override
    public List<DetallePago> getAllDetalle() {
        return detalleRepository.findAll();
    }
}
