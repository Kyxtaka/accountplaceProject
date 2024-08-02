package com.accountplace.api.controller.data;

import com.accountplace.api.domains.data.EntiteGroupe;
import com.accountplace.api.dto.GroupDto;
import com.accountplace.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/create")
    public EntiteGroupe createGroup(@RequestBody EntiteGroupe group) {
        EntiteGroupe result = null;
        try {
            result = groupService.createGroup(group);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/update")
    public EntiteGroupe updateGroup(@RequestParam("id") Integer id,@RequestBody EntiteGroupe group) {
        EntiteGroupe result = null;
        try {
            result = groupService.updateGroup(id, group);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/delete")
    public String deleteGroup(@RequestParam("id") Integer id) {
        String result = null;
        try {
            result = groupService.deleteGroupById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/all")
    public List<EntiteGroupe> getAllGroups() {
        List<EntiteGroupe> result = null;
        try {
            result = groupService.listGroups();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/byId")
    public EntiteGroupe getGroupById(@RequestParam("id") Integer id) {
        EntiteGroupe result = null;
        try {
            result = groupService.getGroupById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/dto")
    public GroupDto getGroupDto(@RequestParam("id") Integer id) {
        GroupDto result = null;
        try {
            result = groupService.getGroupDtoById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/search")
    public List<EntiteGroupe> searchGroup(@RequestParam("name") String name) {
        List<EntiteGroupe> result = null;
        try {
            result = groupService.listGroupByName(name);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }


}
