package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Pago;

import java.util.List;

public interface PagoService {

    public Pago addPago(Pago pago);

    public Pago getPago(long idPago);

    public Pago updatePago(Pago pago);

    public void deletePagoId(long idPago);

    public List<Pago> getAllPago();

}