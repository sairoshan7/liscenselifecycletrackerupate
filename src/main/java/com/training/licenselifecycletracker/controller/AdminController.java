package com.training.licenselifecycletracker.controller;

import com.training.licenselifecycletracker.dto.DeviceDTO;
import com.training.licenselifecycletracker.dto.LifecycleEventDTO;
import com.training.licenselifecycletracker.dto.SoftwareDTO;
import com.training.licenselifecycletracker.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class AdminController {

     

    @Autowired
    DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceDTO> addDevice(@RequestBody DeviceDTO deviceDTO) {
        DeviceDTO addedDevice = deviceService.addDevice(deviceDTO);
        return new ResponseEntity<>(addedDevice, HttpStatus.CREATED);
    }

    @PostMapping("/update/{deviceId}")
    public ResponseEntity<DeviceDTO> updateDevice(@PathVariable Integer deviceId, @RequestBody DeviceDTO deviceDTO) {
        deviceDTO.setDeviceId(deviceId); // Set the deviceId from the path variable
        DeviceDTO updatedDevice = deviceService.updateDevice(deviceDTO);
        return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
    }
    @GetMapping("/getdevice/{deviceId}")
    public ResponseEntity<DeviceDTO> getDeviceById(@PathVariable Integer deviceId) {
        DeviceDTO device = deviceService.getDeviceById(deviceId);
        if (device != null) {
            return new ResponseEntity<>(device, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getalldevice")
    public ResponseEntity<List<DeviceDTO>> getAllDevices() {
        List<DeviceDTO> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{deviceId}")
    public ResponseEntity<Void> deleteDevice(@RequestParam Integer deviceId) {
        deviceService.deleteDevice(deviceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{deviceId}/software")
    public ResponseEntity<DeviceDTO> addSoftwareToDevice(@PathVariable Integer deviceId, @RequestBody SoftwareDTO softwareDTO) {
        DeviceDTO deviceWithSoftware = deviceService.addSoftwareToDevice(deviceId, softwareDTO);
        return new ResponseEntity<>(deviceWithSoftware, HttpStatus.OK);
    }

    @PostMapping("/{deviceId}/lifecycle-events")
    public ResponseEntity<DeviceDTO> addLifecycleEventToDevice(@PathVariable Integer deviceId, @RequestBody LifecycleEventDTO lifecycleEventDTO) {
        DeviceDTO deviceWithLifecycleEvent = deviceService.addLifecycleEventToDevice(deviceId, lifecycleEventDTO);
        return new ResponseEntity<>(deviceWithLifecycleEvent, HttpStatus.OK);
    }
}
