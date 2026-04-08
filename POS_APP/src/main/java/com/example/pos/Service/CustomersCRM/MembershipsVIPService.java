package com.example.pos.Service.CustomersCRM;

import com.example.pos.Entity.CustomersCRM.MembershipsVIP;
import java.util.List;
import java.util.Optional;

public interface MembershipsVIPService {
    List<MembershipsVIP> all();
    List<MembershipsVIP> index();
    Optional<MembershipsVIP> show(Long id);
    MembershipsVIP store(MembershipsVIP entity);
    MembershipsVIP update(Long id, MembershipsVIP entity);
    void destroy(Long id);
}
