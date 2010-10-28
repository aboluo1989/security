package org.jboss.seam.security.management.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.picketlink.idm.api.Role;
import org.picketlink.idm.api.User;

public @Model class UserSearch implements Serializable
{
   private static final long serialVersionUID = 8592034786339372510L;

   List<UserDTO> users;
        
   private boolean loaded;
   
   public void loadUsers()
   {
      loaded = true;
      users = new ArrayList<UserDTO>();
      
      Collection<User> results = null; // identityManager.findUsers(null);  
      for (User user : results)
      {
         UserDTO dto = new UserDTO();
         dto.setUsername(user.getId());
         //dto.setEnabled(identityManager.isUserEnabled(user.getId()));
         users.add(dto);
      }      
   }
   
   public String getUserRoles(String username)
   {
      Collection<Role> roles = null; //identityManager.getUserRoles(username);
            
      StringBuilder sb = new StringBuilder();
      
      for (Role role : roles)
      {
         sb.append((sb.length() > 0 ? ", " : "") + role.getRoleType().getName() + 
               ":" + role.getGroup().getName());
      }
      
      return sb.toString();
   }
   
   public List<UserDTO> getUsers()
   {
      if (!loaded) loadUsers();
      return users;
   }   
   
}