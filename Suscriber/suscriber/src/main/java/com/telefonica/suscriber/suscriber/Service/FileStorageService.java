package com.telefonica.suscriber.suscriber.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.suscriber.suscriber.Models.Disponibilidad;

@Service
public class FileStorageService {
    private final String filePath = "solicitudes.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public synchronized Map<String, Disponibilidad> cargarSolicitudes()
    {
        try
        {
            File file = new File(filePath);
            if(!file.exists()) return new HashMap<>();
            return mapper.readValue(file, new TypeReference<Map<String,Disponibilidad>>(){});
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return new HashMap<>();
        }

    }

    public synchronized void guardarSolicitudes(Map<String, Disponibilidad> solicitudes)
    {
        try
        {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), solicitudes);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
