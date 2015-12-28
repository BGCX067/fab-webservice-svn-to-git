package fab.formatic.web.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.domain.FabCustomer;

/**
 * @author gilang
 *
 */
@Service(FabWSHelper.CUSTOMER_USERDETAILS_SERVICE)
public class FabCustomerDetailService implements UserDetailsService {

	@Autowired
	private FabCustomerDao customerDao;

	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		if (username == null || StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("no username");
		}

		FabCustomer fc = customerDao.findByAdminEmail(username);
		if (fc == null) {
			throw new UsernameNotFoundException("no username");
		}

		FabCustomerDetails details=new FabCustomerDetails(fc);
		return details;
	}

}
