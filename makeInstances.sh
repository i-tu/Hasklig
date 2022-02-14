#!/usr/bin/env bash

# We're just testing if 'makeInstancesUFO' exists, otherwise we'll attempt to use the lowercase variant.
function makeInstancesUFO() { 
  [[ -z "$(which makeInstancesUFO)" ]] \
    && makeinstancesufo $argv || makeInstancesUFO $argv
}

makeInstancesUFO -d Roman/Masters/SourceCodePro.designspace
makeInstancesUFO -d Italic/Masters/SourceCodePro-Italic.designspace
