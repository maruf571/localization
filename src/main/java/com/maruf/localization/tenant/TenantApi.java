package com.maruf.localization.tenant;

import com.maruf.localization.tenant.entity.Tenant;
import com.maruf.localization.tenant.service.TenantService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protected/tenant")
public class TenantApi {

    private final TenantService tenantService;
    public TenantApi(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        return ResponseEntity.ok()
                .body(tenantService.findAll(pageable));
    }

    @GetMapping("/{tenantId}")
    public ResponseEntity findById(@PathVariable String businessId){
        return ResponseEntity.ok()
                .body(tenantService.findById(businessId));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Tenant tenant){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tenantService.create(tenant));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Tenant tenant){
        return ResponseEntity.ok()
                .body(tenantService.update(tenant));
    }

    @DeleteMapping("/{tenantId}")
    public void delete(@RequestParam String businessId){
        tenantService.delete(businessId);
    }

}
