# Expanse
Custom World Generator for Sponge



###Example world.conf file using recommended version of Sponge 
```
# 1.0
# 
# # If you need help with the configuration or have any questions related to Sponge,
# # join us at the IRC or drop by our forums and leave a post.
# 
# # IRC: #sponge @ irc.esper.net ( https://webchat.esper.net/?channel=sponge )
# # Forums: https://forums.spongepowered.org/
# 

sponge {
    player-block-tracker {
        # Block IDs that will be blacklisted for player block placement tracking.
        block-blacklist=null
    }
    world {
        # If 'true', this world will generate its spawn the moment its loaded.
        generate-spawn-on-load=true
    }
    # World Generation Modifiers to apply to the world
    world-generation-modifiers=[
        "expanse:oreworld"
    ]
}
```
