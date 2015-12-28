package fab.formatic.web.util;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import fab.formatic.backend.domain.FabCustomer;

/**
 * @author gilang
 *
 */
public class FabCustomerDetails implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	
	private FabCustomer customer;
	
	public FabCustomerDetails(FabCustomer customer)
	{
		this.customer=customer;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_FAB_CUSTOME"));
		return authorities;
	}

	public String getPassword() {
		return customer.getPassword();
	}

	public String getUsername() {
		return customer.getAdminEmail();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public FabCustomer getCustomer() {
		return customer;
	}

	

}
