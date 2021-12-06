package com.example.controller;

import com.example.service.RewardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/rewards"})
public class RewardController {

    private static final Logger logger = LogManager.getLogger(RewardController.class);

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping(path = {"/{customerId}"})
    public Integer getRewards(@PathVariable Integer customerId) {
        logger.info(String.format("getRewards customerId %s", customerId));
        return rewardService.getRewards(customerId);
    }
}
