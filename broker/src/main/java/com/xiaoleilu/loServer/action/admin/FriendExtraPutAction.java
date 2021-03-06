/*
 * This file is part of the Wildfire Chat package.
 * (c) Heavyrain2012 <heavyrain.lee@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xiaoleilu.loServer.action.admin;

import cn.wildfirechat.common.APIPath;
import cn.wildfirechat.common.ErrorCode;
import cn.wildfirechat.pojos.InputUpdateFriendExtra;
import com.xiaoleilu.loServer.RestResult;
import com.xiaoleilu.loServer.annotation.HttpMethod;
import com.xiaoleilu.loServer.annotation.Route;
import com.xiaoleilu.loServer.handler.Request;
import com.xiaoleilu.loServer.handler.Response;
import io.netty.handler.codec.http.FullHttpRequest;

@Route(APIPath.Friend_Set_Extra)
@HttpMethod("POST")
public class FriendExtraPutAction extends AdminAction {

    @Override
    public boolean isTransactionAction() {
        return true;
    }

    @Override
    public boolean action(Request request, Response response) {
        if (request.getNettyRequest() instanceof FullHttpRequest) {
            InputUpdateFriendExtra input = getRequestBody(request.getNettyRequest(), InputUpdateFriendExtra.class);
            ErrorCode errorCode = messagesStore.setFriendExtraRequest(input.getOperator(), input.getTargetId(), input.getExtra(), new long[1]);
            setResponseContent(RestResult.resultOf(errorCode), response);
        }
        return true;
    }
}
