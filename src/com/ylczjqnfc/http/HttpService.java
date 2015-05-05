package com.ylczjqnfc.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class HttpService {
	
	/*private static final String TAG = "HttpService";
	
	static String PROTOCOL_2 = "003";
	
	public HttpService(){
	}
	// 鐗堟湰淇℃伅
	public String GetUpGrade(String clientType, String model, String imei) {
		String result = "";
		try {
			result = MyAsnyctask
					.ApduOnline(JsonUpGrade(clientType, model, imei));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//鏌ヨ鍦伴搧浠ュ強鍛ㄨ竟淇℃伅
	public String GetMetroInfo(String subMessageCode,String clientType)
	{
		String result = "";
		try {
			result = MyAsnyctask
					.ApduOnline_serchmetroinfo(JsonGetMetroInfo(subMessageCode,clientType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 璐︽埛浣欓
	public String GetAccountBalance(String cardBalance, String cardType) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonBalanceData(cardBalance,
					cardType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 鑾峰彇鐭俊鏍￠獙鐮�
	public String GetMsg(String customerName, String type, String mobileCode,
			String orderCode, String amount, String supportType) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonMsgData(customerName, type,
					mobileCode, orderCode, amount, supportType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//鐗堟湰鍗囩骇鏂�
	
	public String getUpGrade(String str1,String str2,String str3,String str4,String str5)
	{
		String result = "";
		try {
				result = MyAsnyctask.ApduOnline(JsonGet_Upgrade(str1,str2,str3,str4,str5));
		} catch (Exception e) {
				e.printStackTrace();
		}
		return result;
	}
	
	//鑾峰彇e涔愮敓娲荤殑url
	public String getEHappyLife(String str1, String str2){
		String result = "";
		try {
			//str1,str2鏄悜鍚庡彴浼犻�鐨勫弬鏁�
			result = MyAsnyctask.ApduOnline(JsonGet_EHappyLifeUrl(str1,str2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	*//**
	 * 鐢熸垚鎸囧畾绫诲瀷鐨勫垎浜孩鍖�
	 *//*
	public  String getSharegetRP(String packetType)
	{
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsongetSharegetRP(packetType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//鏀粯绗洓閮ㄩ敊璇彂閫侀�鐭�
	public String SendMessageToT(String orderId, String cardNo, String txnAmtBefor,String txnAmtAfter,String responseCode,String mchntid,String reserved,String bgUrl,String txnSeqNo,String txnAmt) {
			String result = "";
			try {
				result = MyAsnyctask.Apdu_SendMassage(JsonSendMessageToT(orderId, cardNo, txnAmtBefor,txnAmtAfter,responseCode,mchntid,reserved,bgUrl,txnSeqNo,txnAmt));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
	}
	
	
	// 鍦堝瓨
	public String GetOnLineRechange(String orderId, String rechangeAmount,
			String cardNo, String appSign, String password,String addinfo) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataOnLineRechange("123456789",
					rechangeAmount, cardNo, appSign, password,addinfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 娑堣垂
	public String GetOnLinePayment(String orderId, String rechangeAmount,
			String cardNo, String password, String mchntid, String appSign) {
		String result = "";
		try {
			// String mchntid = GlobalVar.conditions.getResources().getString(
			// R.string.mchntid);
			result = MyAsnyctask.ApduOnline(JsonDataOnLinePayment(orderId,
					rechangeAmount, cardNo, password, mchntid, appSign));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鐢熸垚绀煎搧鍗¤鍗�
	public String GetGiftCardOrder(String type, String parValue) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataGiftCardOrder(type,
					parValue));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 绀煎搧鍗″晢鍝佷俊鎭�
	public String GetGiftCardMsg() {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataGiftCard());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 璁㈠崟
	public String GetOrder(String orderCode){
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataOrderCode(orderCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鐢靛奖绁ㄦ柊鎺ュ彛
	public String GetMovieAll(String cinemaID, String cityId) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnlineLong(JsonDataMovieAll(cinemaID,
					cityId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏀粯瀹濈櫥褰�
	public String GetAlipayLogn() {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonAlipayLogn());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鐢熸垚QB璁㈠崟
	public String GetQBOrder(String goodsCode, String charge_account) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonQBOrder(goodsCode,
					charge_account));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String GetAppLogon(String mobileCode, String smsCode, String model,String imei) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonAppLogon(mobileCode, smsCode,
					model,imei));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏀粯瀹濈敤鎴蜂俊鎭�
	public String GetAlpayUser(String authCode, String userId) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonAlipayUser(authCode, userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏍规嵁token鑾峰緱鍗″彿
	public String GetCards() {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonGetCards());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏍规嵁token鑾峰緱鍗″彿
	public String GetQBMsg() {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonGetQBMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏈哄瀷鐧藉悕鍗�
	public String GetWhiteList(String currentVer) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonWhitelist(currentVer));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

		public String GetSearchWhitelist(String model, String time, String jidai,
				String pda,String Chip_Id, String Version_Mark) {
			String result = "";
			try {
				result = MyAsnyctask.ApduOnline(JsonSearchWhitelist(model, time,
						jidai,pda,Chip_Id,Version_Mark));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
//	// 鏌ヨ鏈哄瀷鐧藉悕鍗�nxp鑺墖)
//	public String GetSearchWhitelist(String model, String time, String jidai,
//			String pda) {
//		String result = "";
//		try {
//			result = MyAsnyctask.ApduOnline(JsonSearchWhitelist(model, time,
//					jidai, pda));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	// 鏌ヨ鏈哄瀷鐧藉悕鍗�鍗氶�鑺墖)
//	public String GetSearchWhitelist_botong(String model, String Chip_Id, String Version_Mark)
//	{
//		String result = "";
//		try {
//			result = MyAsnyctask.ApduOnline(JsonSearchWhitelist_botong(model, Chip_Id,
//					Version_Mark));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

	// 鏀粯瀹濈粨鏋滃彂閫�
	public String GetAlipayResult(String model) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonAlipayResult(model));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String GetAccountRecord(String txnAmt, String cardNo,
			String orderId, String refundType, String apduPageNo,
			String cardBalance, String oldBalance, String apdu) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonAccountRecord(txnAmt, cardNo,
					orderId, refundType, apduPageNo, cardBalance, oldBalance,
					apdu));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏀粯瀹濇敮浠�
	public String GetAlpayPay(String tranAmount) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonAlipayPay(tranAmount));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鐢靛奖绁�鐢靛奖淇℃伅,寰幆鑾峰彇
	// public String GetFilmMsg(String cinemaID) {
	// String result = "";
	// try {
	// result = MyAsnyctask.ApduOnlineFilm(cinemaID);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }

	// 鐢靛奖绁�褰遍櫌鍒楄〃
	public String GetCinemaMsg(String cityId) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnlineLong(JsonDataCinemaMsg(cityId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String GetOrder_ccb(String orderCode) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataOrderCode_CCB(orderCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	*//**
	 *娑堟伅鎺ㄩ�
	 * @param currentPage
	 * @param pageSize
	 * @return
	 *//*
	public String GetMovementMessage(String messagecode)
	{
		String result="";
		try {
			result = MyAsnyctask.ApduOnline(JsonMovementMessage(messagecode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	// 绉垎
		public String GetPointsDetail(String currentPage, String pageSize) {
			String result = "";
			try {
				result = MyAsnyctask.ApduOnline(JsonPointsDetailData(currentPage,
						pageSize));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
		//绗笁鏂规秷璐�
		public  String orderPay(String merchantcoede,String bankType,String transAmount,String reserved,String orderCode)
		{
			String result = "";
			try {
				result = MyAsnyctask.ApduOnline_serchmetroinfo(JsonOrderPay(merchantcoede,
						bankType,transAmount,reserved,orderCode));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
		// 绉垎鍒ゆ柇鑳藉惁鍏戞崲
		public String GetPointsIsExchange(String exchangeId) {
			String result = "";
			try {
				result = MyAsnyctask
						.ApduOnline_point(JsonDataIsExchangeRechange(exchangeId));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//寰楀埌鐧诲綍鐢ㄦ埛鐨勫緟閫�鍒楄〃
		public String  GetRefund_List()
		{
			String result = "";
			try {
				result = MyAsnyctask
						.ApduOnline_serchmetroinfo(JsonData_GetReFund_List());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//寰楀埌鍙戦�绾㈠寘鐨勮鍗曚俊鎭�
		public String GetRedPacketOrder(String str1,String str2)
		{
			String result = "";
			try {
				result = MyAsnyctask
						.ApduOnline_serchmetroinfo(JsonData_GetRedPacketOrder(str1,str2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//寮傚父閫�
		public String RefundMoney(String orderCode,String type,String apdu,String nowBalance,String oldBalance,String refundType,String mCardNo)
		{
			String result = "";
			try {
				result = MyAsnyctask
						.ApduOnline_serchmetroinfo(JsonDataRefundMoney(orderCode,type,apdu,nowBalance,oldBalance,refundType,mCardNo));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
		public List<NameValuePair> JsonData_GetReFund_List() {
			String encoder = "";
			JSONObject data = new JSONObject();
			encoder = AESUtil.encrypt(data.toString());
			return jsonList(HTTPMap.HTTP_GET_REFUND_LIST_R, encoder, PROTOCOL_2);

		}
		
		public List<NameValuePair> JsonData_GetRedPacketOrder(String str1,String Str2) {
			String encoder = "";
			JSONObject data = new JSONObject();
			try {
				data.put("amount", str1);
				data.put("recipientMobileCode", Str2);
				encoder = AESUtil.encrypt(data.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonList(HTTPMap.HTTP_REDPACKET_ORDER_R, encoder, PROTOCOL_2);//""涓哄崱鍙�

		}
		
		
		public List<NameValuePair> JsonDataRefundMoney(String orderCode,String type,String apdu,String nowBalance,String oldBalance,String refundType,String mCardNo) {
			String encoder = "";
			JSONObject data = new JSONObject();
			try {
				data.put("orderCode", orderCode);
				data.put("type", type);
				data.put("apdu", apdu);
				data.put("nowBalance", nowBalance);
				data.put("oldBalance", oldBalance);
				data.put("refundType", refundType);
				encoder = AESUtil.encrypt(data.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			Log.i(TAG, "--->"+mCardNo);
			return jsonList_addcard(HTTPMap.HTTP_REFUNDMONEY_R, encoder, PROTOCOL_2,mCardNo);//""涓哄崱鍙�
//			return jsonList(HTTPMap.HTTP_REFUNDMONEY_R, encoder, PROTOCOL_2);

		}
		
		
		public List<NameValuePair> JsonDataIsExchangeRechange(String exchangeId) {
			String encoder = "";
			JSONObject data = new JSONObject();
			try {
				data.put("exchangeId", exchangeId);
				encoder = AESUtil.encrypt(data.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonList(HTTPMap.HTTP_POINTS_IS_EXCHANGE_R, encoder, PROTOCOL_2);

		}
	
	// 绉垎鍏戞崲
	// public String GetPointsExchange(String exchangeId) {
	// String result = "";
	// try {
	// result = MyAsnyctask
	// .ApduOnline(JsonDataExchangeRechange(exchangeId));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }

	// 閾惰仈鍏呭�
	public String GetYLRechange(String rechangeAmount) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataYLRechange(rechangeAmount));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// // 寤鸿鍏呭�
	// public String GetCCBRechange(String rechangeAmount) {
	// String result = "";
	// try {
	// result = MyAsnyctask
	// .ApduOnline(JsonDataCCBRechange(rechangeAmount));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }

	// 鍗″彿鏄惁宸叉敞鍐�
	public String GetCardIsRegister(String CardNo) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonCardIsRegisterData(CardNo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鐢ㄦ埛鍚嶆槸鍚﹀凡娉ㄥ唽
	public String GetNameIsRegister(String customerName) {
		String result = "";
		try {
			result = MyAsnyctask
					.ApduOnline(JsonNameIsRegisterData(customerName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏀粯瀹濋�娆�
	public String GetRefund(String orderCode, String type, String refundType,
			String apduPageNo, String cardBalance, String oldBalance,
			String apdu) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonRefundData(orderCode, type,
					refundType, apduPageNo, cardBalance, oldBalance, apdu));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 閾惰閫�璁板綍
	public String GetRefundRecord(String currentPage, String pageSize,
			String timeRangeStatus, String queryType) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonRefundRecordData(currentPage,
					pageSize, timeRangeStatus, queryType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 浜ゆ槗璁板綍
	public String GetReferRecord(String cardNo, String currentPage,
			String pageSize, String timeRangeStatus, String queryType) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonReferRecordData(cardNo,
					currentPage, pageSize, timeRangeStatus, queryType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 璐︽埛鏀粯鐢熸垚URL
	public String GetPaymentUrl(String prevMsgType, String orderId,
			String type, String productName, String productNum,
			String productDesc, String reserved ,String paytype) {
		String result = "";
		try {
			if(paytype.equals("1"))
			{
				//寰楀埌url鍚庤繘琛岄摱琛屾垨鑰呮敮浠樺疂璐︽埛娑堣垂
				result = MyAsnyctask.ApduOnline_serchmetroinfo(JsonPaymentURLData(prevMsgType,
						orderId, type, productName, productNum, productDesc,
						reserved));
			}
			else
			{
				//寰楀埌url鍚庤繘琛屽崱娑堣垂
				result = MyAsnyctask.ApduOnline(JsonPaymentURLData(prevMsgType,
						orderId, type, productName, productNum, productDesc,
						reserved));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 鎵嬫満鍏呭�棰濊幏鍙�
	public String GetPhoneAmount(String mobileNum, String prodType,
			String ispType) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonPhoneAmountData(mobileNum,
					prodType, ispType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鎵嬫満鍥鸿瘽鍏呭�
	public String GetPhonePay(String mobileNum, String prodType,
			String ispType, String goodsID) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonPhonePay(mobileNum, prodType,
					ispType, goodsID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鐢靛奖绁�璁㈠崟
	public String GetFilmOrder(String txnAmt, String productName,
			String productNum, String productDesc, String reserved) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnlineLong(JsonFilmOrder(txnAmt,
					productName, productNum, productDesc, reserved));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏌ヨ璇濊垂瀹為檯閲戦
	public String GetPhonePrice(String goodsListPrice, String ispType,
			String prodDelayTime, String provinceName, String prodType) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonPhonePrice(goodsListPrice,
					ispType, prodDelayTime, provinceName, prodType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏌ヨ鍗＄墖鍏呭�鍓嶇姸鎬�
	public String GetCardState(String cardBalance, String cardType) {
		String result = "";
		try {
			result = MyAsnyctask
					.ApduOnline(JsonCardState(cardBalance, cardType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 鏌ヨ搴т綅淇℃伅锛�064锛�
	public String GetQueryInfo(String cinemaID, String showSeqNo) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnlineLong(JsonQueryInfo(cinemaID,
					showSeqNo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//鍙岃壊鐞冪敓鎴愯鍗�
	public String GetCp_ssqinfo(String lotIssue, String lotCode,String lotMulti) {
		String result = "";
		try {
			result = MyAsnyctask.Apdu_getCp_order(JsonGetCp_orderInfo(lotIssue,
					lotCode,lotMulti));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//閾惰鍏呭�鍒楄〃鏌ヨ
	public String getpaystyle(String str1,String str2)
	{
		String result = "";
		try {
			result = MyAsnyctask.Apdu_get_redpacket_credit(JsonGet_getpaystyle(str1,str2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//绾㈠寘閫� 
		public String redPacket_REFUND(String str1,String str2,String str3,String str4,String str5)
		{
			String result = "";
			try {
				result = MyAsnyctask.Apdu_get_redpacket_credit(JsonGet_redpacket_Refund(str1,str2,str3,str4,str5));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
	*//**
	 * 鏌ヨ寤鸿杩斿洖鐨勬寚瀹氱孩鍖�
	 * @param recordId
	 * @return
	 *//*
	public String getccbpay_redp(String recordId,String phone)
	{
		String result = "";
		try {
			result = MyAsnyctask.Apdu_get_redpacket_credit(JsonGet_ccbpay_redp(recordId,phone));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//灏嗚閫�
	public String ccb_Refund(String str1)
	{
		String result = "";
		try {
			result = MyAsnyctask.Apdu_get_redpacket_credit(JsonGet_ccb_Refund(str1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//绾㈠寘閫�
	public String redPacket_Refund(String str1,String str2,String str3,String str4,String str5)
	{
		String result = "";
		try {
			result = MyAsnyctask.Apdu_get_redpacket_credit(JsonGet_redpacket_Refund(str1,str2,str3,str4,str5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//绾㈠寘鍏呭�
	public String redPacketCredit(String recordId)
	{
		String result = "";
		try {
			result = MyAsnyctask.Apdu_get_redpacket_credit(JsonGet_redpacket_Credit(recordId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//寰楀埌绾㈠寘鍒楄〃
	public String GetCp_redPacket(String str1,String str2,String str3,String str4) {
		String result = "";
		try {
			result = MyAsnyctask.Apdu_get_redpacket(JsonGet_redpacket(str1,str2,str3,str4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//涓俊閾惰璁㈠崟
	public String GetOrder_zx(String tranAmount) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnline(JsonDataZXRechange(tranAmount));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//鍑鸿璁板綍鍒ゆ柇鏄惁寮�埛锛岃蛋蹇冭烦鎶ユ枃
		public String open_Account(String str1){
			String result = "";
			try {
				result = MyAsnyctask.ApduOnline(JsonDataHeartBeat(str1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public List<NameValuePair> JsonDataHeartBeat(String heartBeatMsg) {
			String encoder = "";
			JSONObject data = new JSONObject();
			try {
				// data.put("customerName", GlobalVar.customerName);
				data.put("reserved", heartBeatMsg);
				encoder = AESUtil.encrypt(data.toString());
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonList(HTTPMap.HTTP_HEAT_R, encoder, PROTOCOL_2);

		}
		//缁戝崱鎶ユ枃
		public String addCard(String str1,String str2)
		{
			String result = "";
			try{
				result = MyAsnyctask.ApduOnline(JsonDataAddCard(str1,str2));
				}catch(Exception e){
					e.printStackTrace();
				}
			return result;
		}
		//鍑鸿璁板綍
		public String getchuxingjilu(String str1)
		{
			String result = "";
			try{
				result = MyAsnyctask.ApduOnline(JsonDatachuxing(str1));
				}catch(Exception e){
					e.printStackTrace();
				}
			return result;
		}
		
		
		
		//瑙ｉ櫎鍗＄粦瀹�
		public String cancelCardBound(String str1,String str2){
			String result = "";
			try{
				result = MyAsnyctask.ApduOnline(JsonDataCancelBound(str1,str2));
				}catch(Exception e){
					e.printStackTrace();
				}
			return result;
		}
		//瑙ｉ櫎鍗＄粦瀹氭墍闇�浼犵殑鍊硷紙cardNo鍜宼oken锛�
		public List<NameValuePair> JsonDataCancelBound(String cardNo,String token) {
			String encoder = "";
			JSONObject data = new JSONObject();
			try {
				// data.put("customerName", GlobalVar.customerName);
				data.put("cardNo", cardNo);
				data.put("token", token);
				encoder = AESUtil.encrypt(data.toString());
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonList(HTTPMap.HTTP_CARD_BOUND_CANCEL_R, encoder, PROTOCOL_2);

		}
		
		//瑙ｉ櫎鍗＄粦瀹氭墍闇�浼犵殑鍊硷紙cardNo鍜宼oken锛�
				public List<NameValuePair> JsonDataAddCard(String cardNo1,String token) {
					String encoder = "";
					JSONObject data = new JSONObject();
					try {
						// data.put("customerName", GlobalVar.customerName);
						data.put("cardNo", cardNo1);
						data.put("token", token);
						encoder = AESUtil.encrypt(data.toString());
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					return jsonList_addcard(HTTPMap.HTTP_ADDCARD_R, encoder, PROTOCOL_2,cardNo1);

				}
		
				
				public List<NameValuePair> JsonDatachuxing(String cardNo2) {
					String encoder = "";
					JSONObject data = new JSONObject();
					try {
						// data.put("customerName", GlobalVar.customerName);
						data.put("cardNo", cardNo2);
						encoder = AESUtil.encrypt(data.toString());
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					return jsonList_getchuxing(HTTPMap.HTTP_CHUXING_R, encoder, PROTOCOL_2,cardNo2);

				}
		
	// 閿佸畾搴т綅锛�067锛�

	public String GetLockInfo(String cinemaID, String amountprice, String date,
			String filmID, String lockSeatNum, String lockSeats, String mobile,
			String showSeqNo) {
		String result = "";
		try {
			result = MyAsnyctask.ApduOnlineLong(JsonLockInfo(cinemaID,
					amountprice, date, filmID, lockSeatNum, lockSeats, mobile,
					showSeqNo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<NameValuePair> JsonCardState(String cardBalance, String cardType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("cardBalance", cardBalance);
			data.put("cardType", cardType);
			data.put("cardNo", GlobalVar.cardNo);
			data.put("clientVer", GlobalVar.localVersion);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CARD_STATE_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonPhonePrice(String goodsListPrice,
			String ispType, String prodDelayTime, String provinceName,
			String prodType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("goodsListPrice", goodsListPrice);
			data.put("ispType", ispType);
			data.put("prodDelayTime", prodDelayTime);
			data.put("provinceName", provinceName);
			data.put("prodType", prodType);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_PHONE_PRICE_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonMsgData(String customerName, String type,
			String mobileCode, String orderCode, String amount,
			String supportType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("customerName", customerName);
			data.put("type", type);
			data.put("mobileCode", mobileCode);
			data.put("orderCode", orderCode);
			data.put("amount", amount);
			data.put("supportType", supportType);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_GET_MSG_R, encoder, PROTOCOL_2);
	}

	public List<NameValuePair> JsonCinemaMsg() {
		String encoder = "";
		try {
			encoder = AESUtil.encrypt("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CINEMA_MSG_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonPhonePay(String mobileNum, String prodType,
			String ispType, String goodsID) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("mobileNum", mobileNum);
			data.put("prodDelayTime", "5鍒嗛挓");
			data.put("prodType", prodType);
			data.put("ispType", ispType);
			data.put("goodsID", goodsID);
			data.put("goodsQuantity", "1");
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList_order(HTTPMap.HTTP_PHONE_ORDER_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonCardIsRegisterData(String cardNo) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("cardNo", cardNo);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CARD_ISREGISTER_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonNameIsRegisterData(String customerName) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("customerName", customerName);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_NAME_ISREGISTER_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonRefundData(String orderCode, String type,
			String refundType, String apduPageNo, String cardBalance,
			String oldBalance, String apdu) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("orderCode", orderCode);
			data.put("type", type);
			data.put("refundType", refundType);
			data.put("apduPageNo", apduPageNo);
			data.put("nowBalance", cardBalance);
			data.put("oldBalance", oldBalance);
			data.put("apdu", apdu);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_REFUND_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonRefundRecordData(String currentPage,
			String pageSize, String timeRangeStatus, String queryType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("currentPage", currentPage);
			data.put("pageSize", pageSize);
			data.put("timeRangeStatus", timeRangeStatus);
			data.put("queryType", queryType);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_REFUND_RECORD_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonReferRecordData(String CardNo,
			String currentPage, String pageSize, String timeRangeStatus,
			String queryType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("cardNo", CardNo);
			data.put("currentPage", currentPage);
			data.put("pageSize", pageSize);
			data.put("timeRangeStatus", timeRangeStatus);
			data.put("queryType", queryType);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_REFER_RECORD_R, encoder, PROTOCOL_2);
	}
	
	public List<NameValuePair> JsonPaymentURLData(String prevMsgType,
			String orderId, String type, String productName, String productNum,
			String productDesc, String reserved) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("prevMsgType", prevMsgType);
			data.put("orderId", orderId);
			data.put("type", type);
			data.put("productName", productName);
			data.put("productNum", productNum);
			data.put("productDesc", productDesc);
			data.put("reserved", reserved);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_PAYMENT_URL_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonPhoneAmountData(String mobileNum,
			String prodType, String ispType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("mobileNum", mobileNum);
			data.put("prodDelayTime", "5鍒嗛挓");
			data.put("prodType", prodType);
			// data.put("ispType", ispType);
			// String temp = data.toString().replace("\"", "\'");
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_PHONE_LIST_R, encoder, PROTOCOL_2);

	}

	private List<NameValuePair> JsonDataOnLineRechange(String orderId,
			String rechangeAmount, String cardnum, String appSign,
			String password,String addinfo) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("orderId", orderId);
			data.put("txnAmt", rechangeAmount);
			data.put("cardNo", cardnum);
			data.put("txnType", "0004");
			data.put("appSign", appSign);
			data.put("passWord", password);
			data.put("addInfo",addinfo);
			
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_RECHANGE_R_1, encoder, PROTOCOL_2);
	}

	private List<NameValuePair> JsonDataOnLinePayment(String orderId,
			String rechangeAmount, String cardnum, String password,
			String mchntid, String appSign) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("orderId", orderId);
			data.put("txnAmt", rechangeAmount);
			data.put("cardNo", cardnum);
			data.put("txnType", "0001");
			data.put("customerName", GlobalVar.customerName);
			data.put("passWord", password);
			data.put("mchntid", mchntid);
			data.put("appSign", appSign);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_PAYMENT_R_1, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonDataReferRechange(String type) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("customerName", GlobalVar.customerName);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(type, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonDataGiftCardOrder(String type,
			String parValue) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("type", type);
			data.put("parValue", parValue);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList_order(HTTPMap.HTTP_GIFT_CARD_ORDER_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonDataMovieAll(String cinemaID, String cityId) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("cinemaID", cinemaID);
			data.put("cityId", cityId);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_MOVIE_ALL_R, encoder, PROTOCOL_2);
	}

	public List<NameValuePair> JsonDataCinemaMsg(String cityId) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("cityId", cityId);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CINEMA_MSG_R, encoder, PROTOCOL_2);
	}

	public List<NameValuePair> JsonDataOrderCode_CCB(String orderCode) {
		Double money = 0.0d;
		String aa=orderCode;
		String bb="zzz";
		money = DataChange.dataStrToDouble(orderCode);
		
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("tranAmount", money);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CCB_RECHANGEPP_R, encoder, PROTOCOL_2);
	}
	
	public List<NameValuePair> JsonDataGiftCard() {
		String encoder = "";
		try {
			encoder = AESUtil.encrypt("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_GIFT_CARD_MSG_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonDataOrderCode(String orderCode) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("orderCode", orderCode);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ORDER_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonDataYLRechange(String rechangeAmount) {
		String encoder = "";
		JSONObject data = new JSONObject();
		Double money = 0.0d;
		money = DataChange.dataStrToDouble(rechangeAmount);
		try {
			// data.put("customerName", "");
			data.put("tranAmount", money);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_YL_RECHANGE_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonUpGrade(String clientType, String model,
			String imei) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("clientType", clientType);
			data.put("model", model);
			data.put("imei", imei);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_UP_GRADE_R, encoder, "013");

	}
	
	
	public List<NameValuePair> JsonGetMetroInfo(String subMessageCode,String clientType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("subMessageCode", subMessageCode);
			data.put("clientType", clientType);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_SEARCH_METRO_R, encoder, "013");

	}
	

	public List<NameValuePair> JsonBalanceData(String cardBalance,
			String cardType) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			GlobalVar.cardNo = GlobalVar.cardNo.replace("鈽�, "");
			data.put("customerName", GlobalVar.cardNo);
			data.put("cardBalance", cardBalance);
			data.put("cardType", cardType);
			data.put("DATE", GlobalVar.DATE);
			data.put("BASEBAND", GlobalVar.BASEBAND);
			data.put("PDA", GlobalVar.PDA);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_BALANCE_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonFilmOrder(String txnAmt, String productName,
			String productNum, String productDesc, String reserved) {
		JSONObject data = new JSONObject();
		String encoder = "";
		try {
			data.put("txnAmt", txnAmt);
			data.put("productName", productName);
			data.put("productNum", productNum);
			data.put("productDesc", productDesc);
			data.put("reserved", reserved);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList_order(HTTPMap.HTTP_FILM_ORDER_R, encoder, PROTOCOL_2);

	}
	
	*//**
	 * 閾惰鍐插�鍒楄〃鏌ヨ
	 *//*
	public List<NameValuePair> JsonGet_getpaystyle(String str1,String str2) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("phoneType", str1);
			data.put("transType", str2);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_GETPAYSTYLE_R, encoder, PROTOCOL_2);
	}
	
	*//**
	 * 鏌ヨ寤鸿杩斿洖鐨勬寚瀹氱孩鍖�
	 *//*
	public List<NameValuePair> JsonGet_ccbpay_redp(String recordId,String phone) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("openId", recordId);
			data.put("mobileCode", phone);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CCBPAY_REDP_R, encoder, PROTOCOL_2);
	}
	
	*//**
	 * 寤鸿閫�
	 *//*
	public List<NameValuePair> JsonGet_ccb_Refund(String str1) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("orderCode", str1);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CCB_REFUND_R, encoder, PROTOCOL_2);
	}
	*//**
	 * 绾㈠寘閫�
	 *//*
	public List<NameValuePair> JsonGet_redpacket_Refund(String str1,String str2,String str3,String str4,String str5) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("txnAmt", str1);
			data.put("cardNo", str2);
			data.put("orderId", str3);
			data.put("refundType",str4);
			data.put("recordId", str5);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_REDPACKET_REFUND_R, encoder, PROTOCOL_2);
	}
	
	*//**
	 * 绾㈠寘鍒楄〃
	 *//*
	public List<NameValuePair> JsonGet_redpacket_Credit(String recordId) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("recordId", recordId);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_REDPACKET_CREDIT_R, encoder, PROTOCOL_2);
	}
	
	*//**
	 * 绾㈠寘鍒楄〃
	 *//*
	public List<NameValuePair> JsonGet_redpacket(String str1,String str2,String str3,String str4) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("currentPage", str1);
			data.put("pageSize", str2);
			data.put("queryType", str3);
			data.put("currentVer", str4);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList_order(HTTPMap.HTTP_GET_REDPACKET_R, encoder, "013");

	}
	
	
	*//**
	 * 鐢熸垚鍙岃壊鐞冭鍗曗�鈥斿弬鏁板姞瀵�
	 *//*
	public List<NameValuePair> JsonGetCp_orderInfo(String lotIssue, String lotCode,String lotMulti) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("lotIssue", lotIssue);
			data.put("lotCode", lotCode);
			data.put("lotMulti", lotMulti);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList_order(HTTPMap.HTTP_GET_SCQORDER_R, encoder, PROTOCOL_2);

	}
	
	*//**
	 * 鏌ヨ搴т綅淇℃伅
	 *//*
	public List<NameValuePair> JsonQueryInfo(String cinemaID, String showSeqNo) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("cinemaID", cinemaID);
			data.put("showSeqNo", showSeqNo);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_QUERY_SEAT_R, encoder, PROTOCOL_2);
	}
	*//**
	 * 閿佸畾搴т綅
	 *//*
	public List<NameValuePair> JsonLockInfo(String cinemaID,
			String amountprice, String date, String filmID, String lockSeatNum,
			String lockSeats, String mobile, String showSeqNo) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("cinemaID", cinemaID);
			data.put("amountprice", amountprice);
			data.put("date", date);
			data.put("filmID", filmID);
			data.put("lockSeatNum", lockSeatNum);
			data.put("lockSeats", lockSeats);
			data.put("mobile", mobile);
			data.put("showSeqNo", showSeqNo);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_CONFIRM_SEAT_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonQBOrder(String goodsCode,
			String charge_account) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("goodsCode", goodsCode);
			data.put("charge_account", charge_account);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList_order(HTTPMap.HTTP_QB_ORDER_R, encoder, PROTOCOL_2);
	}
	
	public List<NameValuePair> JsonAppLogon(String mobileCode, String smsCode,
			String model,String imei) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("mobileCode", mobileCode);
			data.put("smsCode", smsCode);
			data.put("model", model);
			data.put("imei", imei);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_APP_LOGON_R, encoder, PROTOCOL_2);
	}
	
	public List<NameValuePair> JsonAlipayLogn() {
		String encoder = "";
		try {
			encoder = AESUtil.encrypt("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ALIPAY_LOGON_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonAlipayUser(String authCode, String userId) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("code", authCode);
			data.put("alipay_user_id", userId);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ALIPAY_USER_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonGetCards() {
		String encoder = "";
		try {
			encoder = AESUtil.encrypt("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_GET_CARDS_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonGetQBMsg() {
		String encoder = "";
		try {
			encoder = AESUtil.encrypt("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_QB_MSG_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonAlipayResult(String result) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("result", result);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ALIPAY_RESULT_R, encoder, PROTOCOL_2);
	}
	 
	
	
	public List<NameValuePair> JsonSearchWhitelist(String model, String time,
			String jidai, String pda,String Chip_Id,
			String Version_Mark) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("mobileType", model);
			data.put("DATE", time);
			data.put("BASEBAND", jidai);
			data.put("PDA", pda);
			data.put("chipId", GlobalVar.Chip_Id);
			data.put("versionMark",GlobalVar.Version_Mark);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_SEARCH_WHITELIST_R, encoder, PROTOCOL_2);
	}
	
//	//鍗氶�鑺墖
//	public List<NameValuePair> JsonSearchWhitelist_botong(String model, String Chip_Id,
//			String Version_Mark) {
//		String encoder = "";
//		JSONObject data = new JSONObject();
//		try {
//			data.put("mobileType", model);
//			data.put("chipId", GlobalVar.Chip_Id);
//			data.put("versionMark",GlobalVar.Version_Mark);
//			encoder = AESUtil.encrypt(data.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return jsonList(HTTPMap.HTTP_SEARCH_WHITELIST_R, encoder, PROTOCOL_2);
//	}
	
	public List<NameValuePair> JsonWhitelist(String currentVer) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("currentVer", currentVer);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_MODEL_WHITELIST_R, encoder, PROTOCOL_2);

	}

	public List<NameValuePair> JsonDataZXRechange(String rechangeAmount) {
		String encoder = "";
		JSONObject data = new JSONObject();
		Double money = 0.0d;
		money = DataChange.dataStrToDouble(rechangeAmount);
		try {
			// data.put("customerName", GlobalVar.customerName);
			data.put("tranAmount", money);
			encoder = AESUtil.encrypt(data.toString());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ZX_RECHANGEPP_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonAccountRecord(String txnAmt, String cardNo,
			String orderId, String refundType, String apduPageNo,
			String cardBalance, String oldBalance, String apdu) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("txnAmt", txnAmt);
			data.put("cardNo", cardNo);
			data.put("orderId", orderId);
			data.put("refundType", refundType);
			data.put("apduPageNo", apduPageNo);
			data.put("nowBalance", cardBalance);
			data.put("oldBalance", oldBalance);
			data.put("apdu", apdu);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ACCOUNT_RECORD_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonMovementMessage(String messagecode) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("messageCode", messagecode);
			encoder = AESUtil.encrypt(data.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_MESSAGE_MOVEMENT_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonOrderPay(String merchantcoede,
			String bankType,String transAmount,String reserved,String orderCode) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("merchantCode", merchantcoede);
			data.put("bankType", bankType);
			data.put("transAmount", transAmount);
			data.put("reserved", reserved);
			data.put("orderCode", orderCode);
			encoder = AESUtil.encrypt(data.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ORDERPAY_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonPointsDetailData(String currentPage,
			String pageSize) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("currentPage", currentPage);
			data.put("pageSize", pageSize);
			encoder = AESUtil.encrypt(data.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_POINTS_DETAIL_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonAlipayPay(String tranAmount) {
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("tranAmount", tranAmount);
			encoder = AESUtil.encrypt(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_ALIPAY_PAY_R, encoder, PROTOCOL_2);
	}
	
	
	public List<NameValuePair> JsongetSharegetRP(String packetType){
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("packetType", packetType);
			encoder = AESUtil.encrypt(data.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_SHARE_CREATERP_R, encoder, PROTOCOL_2);

	}
	
	
	public List<NameValuePair> JsonSendMessageToT(String orderId, String cardNo, String txnAmtBefor,String txnAmtAfter,String responseCode,String mchntid,String reserved,String bgUrl,String txnSeqNo,String txnAmt){
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("orderId", orderId);
			data.put("cardNo", cardNo);
			data.put("txnAmtBefor", txnAmtBefor);
			data.put("txnAmtAfter", txnAmtAfter);
			data.put("responseCode", responseCode);
			data.put("mchntid", mchntid);
			data.put("reserved", reserved);
			data.put("bgUrl", bgUrl);
			data.put("txnSeqNo", txnSeqNo);
			data.put("txnAmt", txnAmt);
			encoder = AESUtil.encrypt(data.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_SENDMESSAGE_R, encoder, PROTOCOL_2);

	}
	
	public List<NameValuePair> JsonGet_Upgrade(String str1,String str2,String str3,String str4,String str5)
	{
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("clientType", str1);
			data.put("imei",str2);
			data.put("model",str3);
			data.put("currentVer",str4);
			data.put("displayResolution", str5);
			encoder = AESUtil.encrypt(data.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_UPGRADE_R, encoder, PROTOCOL_2);
	}
	
	public List<NameValuePair> JsonGet_EHappyLifeUrl(String str1,String str2){
		String encoder = "";
		JSONObject data = new JSONObject();
		try {
			data.put("phoneNum", str1);
			data.put("token",str2);
			encoder = AESUtil.encrypt(data.toString());//瀵规暟鎹繘琛屽姞瀵嗗鐞�
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonList(HTTPMap.HTTP_E_HAPPY_LIFE_R, encoder, PROTOCOL_2);
	}
	
	public static List<NameValuePair> jsonList_getchuxing(String msgType, String encoder,String version,String cardNum1)
		{
		String aa=GlobalVar.token;
		//鍗″彿鍏堝啓姝�
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("msgType", msgType));
		nameValuePair.add(new BasicNameValuePair("data", encoder));
		nameValuePair.add(new BasicNameValuePair("client", "NFC"));
		nameValuePair.add(new BasicNameValuePair("token", GlobalVar.token));
		nameValuePair.add(new BasicNameValuePair("cardNo",cardNum1));
		nameValuePair.add(new BasicNameValuePair("ver", version));
		
		nameValuePair.add(new BasicNameValuePair("headimei",GlobalVar.Headimei));
		if(GlobalVar.Headmodel==null||GlobalVar.Headmodel.equals(""))
		{
			GlobalVar.Headmodel=android.os.Build.MODEL;
		}
		nameValuePair.add(new BasicNameValuePair("headmodel",GlobalVar.Headmodel));
		nameValuePair.add(new BasicNameValuePair("sign", SetMd5.getSignMsg(msgType, encoder)));
		return nameValuePair;
	}
	
	public static List<NameValuePair> jsonList_addcard(String msgType, String encoder,
			String version,String cardNum)
		{
		//鍗″彿鍏堝啓姝�
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("msgType", msgType));
		nameValuePair.add(new BasicNameValuePair("data", encoder));
		nameValuePair.add(new BasicNameValuePair("client", "NFC"));
		nameValuePair.add(new BasicNameValuePair("token", GlobalVar.token));
		nameValuePair.add(new BasicNameValuePair("cardNo",cardNum));
		nameValuePair.add(new BasicNameValuePair("ver", version));
		nameValuePair.add(new BasicNameValuePair("headimei",GlobalVar.Headimei));
		if(GlobalVar.Headmodel==null||GlobalVar.Headmodel.equals(""))
		{
			GlobalVar.Headmodel=android.os.Build.MODEL;
		}
		nameValuePair.add(new BasicNameValuePair("headmodel",GlobalVar.Headmodel));
		nameValuePair.add(new BasicNameValuePair("sign", SetMd5.getSignMsg(msgType, encoder)));
		return nameValuePair;
	}
	
	
	public static List<NameValuePair> jsonList(String msgType, String encoder,
			String version){ 
		String aa=GlobalVar.token;
		//鍗″彿鍏堝啓姝�
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("msgType", msgType));
		nameValuePair.add(new BasicNameValuePair("data", encoder));
		nameValuePair.add(new BasicNameValuePair("client", "NFC"));
		nameValuePair.add(new BasicNameValuePair("token", GlobalVar.token));
		nameValuePair.add(new BasicNameValuePair("cardNo",GlobalVar.cardNo));
		nameValuePair.add(new BasicNameValuePair("ver", version));
		nameValuePair.add(new BasicNameValuePair("headimei",GlobalVar.Headimei));
		if(GlobalVar.Headmodel==null||GlobalVar.Headmodel.equals(""))
		{
			GlobalVar.Headmodel=android.os.Build.MODEL;
		}
		nameValuePair.add(new BasicNameValuePair("headmodel",GlobalVar.Headmodel));
		nameValuePair.add(new BasicNameValuePair("sign", SetMd5.getSignMsg(msgType, encoder)));
		return nameValuePair;
	}
	public static List<NameValuePair> jsonList_order(String msgType, String encoder,String version)
	{
		String aa=GlobalVar.token;
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("msgType", msgType));
		nameValuePair.add(new BasicNameValuePair("data", encoder));
		nameValuePair.add(new BasicNameValuePair("client", "NFC"));
		nameValuePair.add(new BasicNameValuePair("token", GlobalVar.token));
		nameValuePair.add(new BasicNameValuePair("cardNo", ""));
		nameValuePair.add(new BasicNameValuePair("ver", version));
		nameValuePair.add(new BasicNameValuePair("headimei",GlobalVar.Headimei));
		if(GlobalVar.Headmodel==null||GlobalVar.Headmodel.equals(""))
		{
			GlobalVar.Headmodel=android.os.Build.MODEL;
		}
		nameValuePair.add(new BasicNameValuePair("headmodel",GlobalVar.Headmodel));
		nameValuePair.add(new BasicNameValuePair("sign", SetMd5.getSignMsg(msgType, encoder)));
		return nameValuePair;
	}*/

}
