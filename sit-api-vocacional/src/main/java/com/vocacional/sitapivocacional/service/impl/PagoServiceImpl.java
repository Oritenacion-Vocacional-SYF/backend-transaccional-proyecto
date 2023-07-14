package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Pago;
import com.vocacional.sitapivocacional.repository.PagoRepository;
import com.vocacional.sitapivocacional.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    private PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago addPago(Pago pago) {
        return this.pagoRepository.save(pago);
    }

    @Override
    public Pago getPago(long id) {
        Optional<Pago> optionalPago = this.pagoRepository.findById(id);
        return optionalPago.orElse(null);
    }

    @Override
    public Pago updatePago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public void deletePagoId(long id) {
        this.pagoRepository.deleteById(id);
    }

    @Override
    public List<Pago> getAllPago() {
        return pagoRepository.findAll();
    }

}
