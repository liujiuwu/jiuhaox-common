package com.jiuhaox.boot.application.ability;

import com.jiuhaox.boot.model.resp.Resp;

public interface Ability<T, R> {
    /**
     * 能力点执行
     *
     * @param cmd
     * @return
     */

    default Resp<R> executeAbility(T cmd) {
        try {
            AbilityContext.initContext();

            checkHandler(cmd);

            Resp<R> checkIdempotent = checkIdempotent(cmd);
            if (checkIdempotent.isFail()) {
                return checkIdempotent;
            }

            return execute(cmd);
        } finally {
            AbilityContext.clearContext();
        }
    }

    /**
     * 能力点执行前的参数校验
     *
     * @param cmd cmd
     * @return
     */
    void checkHandler(T cmd);

    /**
     * 能力点执行前的幂等校验
     *
     * @param cmd cmd
     * @return false：当前能力点已执行，不再执行业务逻辑、true：当前能力点未执行，继续执行业务逻辑
     */
    Resp<R> checkIdempotent(T cmd);

    /**
     * 执行能力业务
     *
     * @param cmd cmd
     * @return return
     */
    Resp<R> execute(T cmd);
}
