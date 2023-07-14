package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.DetallePago;

import java.util.List;

public interface DetalleService {
    public DetallePago addDetalle(DetallePago oDP);

    public DetallePago getDetalle(long id);

    public DetallePago updateDetalle(DetallePago oDP);

    public void deleteDetalleId(long idPago);

    public List<DetallePago> getAllDetalle();
}
