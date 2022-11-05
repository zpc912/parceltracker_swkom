package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ErrorService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorServiceImpl implements ErrorService {

    private ParcelRepository parceRepository;
}
