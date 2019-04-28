package cn.li.service.impl;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.li.api.service.IUsersService;
import cn.li.common.api.ShopResult;
import cn.li.common.constants.DBTableName;
import cn.li.dao.IUserDAO;
import cn.li.entity.User;
import cn.li.mq.producer.RegistermailboxProducer;
import cn.li.utils.DateUtils;
import cn.li.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceServiceImpl implements IUsersService {
	
	@Autowired
	private IUserDAO userdao;
	@Autowired
	private RegistermailboxProducer registermailboxProducer;
	
	@Value("${messages.queue}")
	private String MESSAGES_QUEUE;
	
	@Override
	public ShopResult regist(User user) {
		user.setCreated(DateUtils.getTimestamp());
		user.setUpdated(DateUtils.getTimestamp());
		String phone =user.getPhone();
		String password =user.getPhone();
		user.setPassword(MD5Util.MD5((phone+password)));
		userdao.save(user, DBTableName.TABLE_MB_USER);
		//队列
		Destination activemqqueue = new ActiveMQQueue(MESSAGES_QUEUE);
		
		//组装报文格式
		String mailMessage
		
		
		return null;
	}

}
